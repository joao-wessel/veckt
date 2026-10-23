package com.vectk.backend.controller;

import com.vectk.backend.dto.ApiResponse;
import com.vectk.backend.dto.SearchDtos.SearchResponse;
import com.vectk.backend.entity.Role;
import com.vectk.backend.entity.SearchResultType;
import com.vectk.backend.security.AuthenticatedUser;
import com.vectk.backend.service.search.GlobalSearchService;
import com.vectk.backend.service.search.SearchUserContext;
import java.util.List;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search")
public class GlobalSearchController {
    private final GlobalSearchService service;
    public GlobalSearchController(GlobalSearchService service) { this.service = service; }

    @GetMapping
    public ApiResponse<SearchResponse> search(@AuthenticationPrincipal AuthenticatedUser user,
                                               @RequestParam(name = "q", required = false) String query,
                                               @RequestParam(required = false) Integer limit,
                                               @RequestParam(required = false) List<SearchResultType> types) {
        return ApiResponse.ok(service.search(new SearchUserContext(user.getTenantId(), user.getId(), user.getAuthorities().stream()
                .map(authority -> Role.valueOf(authority.getAuthority())).collect(java.util.stream.Collectors.toSet())), query, limit, types));
    }
}
