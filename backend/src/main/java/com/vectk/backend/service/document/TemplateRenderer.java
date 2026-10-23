package com.vectk.backend.service.document;

public interface TemplateRenderer {
    String format();
    ResolvedDocument render(String template, DocumentContext context);
}
