package com.veckt.backend.service.home;

import com.veckt.backend.dto.HomeDtos.AttentionItemResponse;
import java.util.List;

public interface AttentionProvider {
    List<AttentionItemResponse> provide(HomeUserContext context);
}
