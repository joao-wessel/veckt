package com.vectk.backend.service.search;

import com.vectk.backend.dto.SearchDtos.SearchResultResponse;
import com.vectk.backend.entity.SearchResultType;
import java.util.List;

public interface GlobalSearchProvider {
    SearchResultType type();
    List<SearchResultResponse> search(SearchUserContext context, String normalizedQuery, int limit);
}
