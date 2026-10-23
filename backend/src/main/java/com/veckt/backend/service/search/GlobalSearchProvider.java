package com.veckt.backend.service.search;

import com.veckt.backend.dto.SearchDtos.SearchResultResponse;
import com.veckt.backend.entity.SearchResultType;
import java.util.List;

public interface GlobalSearchProvider {
    SearchResultType type();
    List<SearchResultResponse> search(SearchUserContext context, String normalizedQuery, int limit);
}
