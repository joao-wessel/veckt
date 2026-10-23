package com.vectk.backend.service;

import com.vectk.backend.dto.SettingsDtos.GeneralSettings;
import com.vectk.backend.dto.SettingsDtos.SmtpSettings;
import com.vectk.backend.entity.PlatformSetting;
import com.vectk.backend.exception.BusinessException;
import com.vectk.backend.repository.PlatformSettingRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Properties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SettingsService {
    private static final String SMTP_KEY = "smtp";
    private static final String GENERAL_KEY = "general";
    private final PlatformSettingRepository repository;
    private final ObjectMapper objectMapper;
    private final String websiteUrl;
    private final String frontendUrl;
    private final String backendUrl;

    public SettingsService(PlatformSettingRepository repository, ObjectMapper objectMapper,
                           @Value("${vectk.public.website-url}") String websiteUrl,
                           @Value("${vectk.public.frontend-url}") String frontendUrl,
                           @Value("${vectk.public.backend-url}") String backendUrl) {
        this.repository = repository;
        this.objectMapper = objectMapper;
        this.websiteUrl = websiteUrl;
        this.frontendUrl = frontendUrl;
        this.backendUrl = backendUrl;
    }

    @Transactional
    public SmtpSettings saveSmtp(SmtpSettings settings) {
        save(SMTP_KEY, settings);
        return settings;
    }

    public SmtpSettings getSmtp() {
        return read(SMTP_KEY, SmtpSettings.class, new SmtpSettings("localhost", 1025, "", "", false, false, "noreply@example.com", "Vectk"));
    }

    @Transactional
    public GeneralSettings saveGeneral(GeneralSettings settings) {
        save(GENERAL_KEY, settings);
        return settings;
    }

    public GeneralSettings getGeneral() {
        return read(GENERAL_KEY, GeneralSettings.class,
                new GeneralSettings("Vectk", websiteUrl, frontendUrl, backendUrl, "pt-BR", "America/Sao_Paulo"));
    }

    public void testSmtp(String to) {
        SmtpSettings settings = getSmtp();
        var sender = new JavaMailSenderImpl();
        sender.setHost(settings.host());
        sender.setPort(settings.port());
        sender.setUsername(settings.username());
        sender.setPassword(settings.password());
        Properties props = sender.getJavaMailProperties();
        props.put("mail.smtp.auth", String.valueOf(settings.username() != null && !settings.username().isBlank()));
        props.put("mail.smtp.ssl.enable", String.valueOf(settings.ssl()));
        props.put("mail.smtp.starttls.enable", String.valueOf(settings.tls()));

        var message = sender.createMimeMessage();
        try {
            var helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(settings.senderEmail(), settings.senderName());
            helper.setTo(to);
            helper.setSubject("Teste de envio - Vectk");
            helper.setText("Servidor SMTP configurado com sucesso.", """
                    <!doctype html>
                    <html lang="pt-BR">
                    <body style="margin:0;background:#EAEDF0;padding:32px;font-family:Inter,Segoe UI,Arial,sans-serif;color:#1F2937;">
                      <div style="max-width:600px;margin:0 auto;background:#ffffff;border:1px solid #d3dcdf;border-radius:26px;overflow:hidden;box-shadow:0 24px 70px rgba(15,23,42,.10);">
                        <div style="height:8px;background:#5B7F86;"></div>
                        <div style="padding:34px;">
                          <img src="cid:vectkLogo" width="174" height="48" alt="Vectk" style="display:block;border:0;outline:none;text-decoration:none;width:174px;height:auto;margin:0 0 18px;">
                          <h1 style="margin:0;font-size:28px;line-height:1.2;">Servidor SMTP configurado</h1>
                          <p style="margin:16px 0 0;color:#526174;font-size:16px;line-height:1.65;">Este e-mail confirma que o Vectk conseguiu enviar mensagens usando as configurações atuais.</p>
                        </div>
                      </div>
                    </body>
                    </html>
                    """);
            helper.addInline("vectkLogo", new ClassPathResource("email/vectk-logo.png"), "image/png");
        } catch (Exception ex) {
            throw new BusinessException("Não foi possível montar o e-mail de teste.");
        }
        sender.send(message);
    }

    private void save(String key, Object value) {
        try {
            var setting = repository.findById(key).orElseGet(PlatformSetting::new);
            setting.setKey(key);
            setting.setValue(objectMapper.writeValueAsString(value));
            repository.save(setting);
        } catch (JsonProcessingException ex) {
            throw new BusinessException("Não foi possível salvar a configuração.");
        }
    }

    private <T> T read(String key, Class<T> type, T fallback) {
        return repository.findById(key)
                .map(PlatformSetting::getValue)
                .map(value -> {
                    try {
                        return objectMapper.readValue(value, type);
                    } catch (JsonProcessingException ex) {
                        return fallback;
                    }
                })
                .orElse(fallback);
    }
}
