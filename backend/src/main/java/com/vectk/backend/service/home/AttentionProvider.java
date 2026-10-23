package com.vectk.backend.service.home;

import com.vectk.backend.dto.HomeDtos.AttentionItemResponse;
import java.util.List;

public interface AttentionProvider {
    List<AttentionItemResponse> provide(HomeUserContext context);
}
