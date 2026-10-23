package com.veckt.backend.controller;

import com.veckt.backend.dto.ApiResponse;
import com.veckt.backend.dto.CalendarDtos.CalendarItemResponse;
import com.veckt.backend.dto.HomeDtos.AttentionItemResponse;
import com.veckt.backend.dto.HomeDtos.HomeActivityResponse;
import com.veckt.backend.dto.HomeDtos.HomeFinancialSummaryResponse;
import com.veckt.backend.dto.HomeDtos.HomeIndicatorsResponse;
import com.veckt.backend.dto.HomeDtos.HomeProjectResponse;
import com.veckt.backend.security.AuthenticatedUser;
import com.veckt.backend.service.home.AttentionQueryService;
import com.veckt.backend.service.home.HomeActivityQueryService;
import com.veckt.backend.service.home.HomeFinancialQueryService;
import com.veckt.backend.service.home.HomeIndicatorsQueryService;
import com.veckt.backend.service.home.HomeProjectQueryService;
import com.veckt.backend.service.home.HomeTodayQueryService;
import com.veckt.backend.service.home.HomeUserContext;
import java.util.List;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tenant/home")
public class HomeController {
    private final AttentionQueryService attention;
    private final HomeTodayQueryService today;
    private final HomeProjectQueryService projects;
    private final HomeIndicatorsQueryService indicators;
    private final HomeFinancialQueryService financial;
    private final HomeActivityQueryService activities;

    public HomeController(AttentionQueryService attention, HomeTodayQueryService today, HomeProjectQueryService projects,
                          HomeIndicatorsQueryService indicators, HomeFinancialQueryService financial, HomeActivityQueryService activities) {
        this.attention = attention; this.today = today; this.projects = projects;
        this.indicators = indicators; this.financial = financial; this.activities = activities;
    }

    @GetMapping("/attention")
    public ApiResponse<List<AttentionItemResponse>> attention(@AuthenticationPrincipal AuthenticatedUser user) {
        return ApiResponse.ok(attention.list(context(user)));
    }
    @GetMapping("/today")
    public ApiResponse<List<CalendarItemResponse>> today(@AuthenticationPrincipal AuthenticatedUser user) {
        return ApiResponse.ok(today.today(context(user)));
    }
    @GetMapping("/projects")
    public ApiResponse<List<HomeProjectResponse>> projects(@AuthenticationPrincipal AuthenticatedUser user) {
        return ApiResponse.ok(projects.mine(context(user)));
    }
    @GetMapping("/indicators")
    public ApiResponse<HomeIndicatorsResponse> indicators(@AuthenticationPrincipal AuthenticatedUser user) {
        return ApiResponse.ok(indicators.get(context(user)));
    }
    @GetMapping("/financial-summary")
    public ApiResponse<HomeFinancialSummaryResponse> financial(@AuthenticationPrincipal AuthenticatedUser user) {
        return ApiResponse.ok(financial.get(context(user)));
    }
    @GetMapping("/activities")
    public ApiResponse<List<HomeActivityResponse>> activities(@AuthenticationPrincipal AuthenticatedUser user) {
        return ApiResponse.ok(activities.recent(context(user)));
    }
    private HomeUserContext context(AuthenticatedUser user) {
        return new HomeUserContext(user.getTenantId(), user.getId(), user.getAuthorities().stream()
                .map(authority -> com.veckt.backend.entity.Role.valueOf(authority.getAuthority())).collect(java.util.stream.Collectors.toSet()));
    }
}
