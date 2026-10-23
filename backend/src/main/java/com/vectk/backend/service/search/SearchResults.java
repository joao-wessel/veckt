package com.vectk.backend.service.search;

import com.vectk.backend.dto.SearchDtos.SearchResultResponse;
import com.vectk.backend.entity.SearchResultType;
import java.util.Map;
import java.util.UUID;

final class SearchResults {
    private SearchResults() {}
    static SearchResultResponse result(UUID id, SearchResultType type, String title, String subtitle,
                                       String description, String actionUrl, String icon) {
        return new SearchResultResponse(id, type, title, subtitle, description, actionUrl, icon, Map.of());
    }
}
