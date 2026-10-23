package com.vectk.backend.service.calendar;

import com.vectk.backend.dto.CalendarDtos.CalendarItemResponse;
import java.time.LocalDate;
import java.util.*;

public interface CalendarEventProvider {
    List<CalendarItemResponse> provide(UUID tenantId, LocalDate start, LocalDate end, CalendarFilters filters);
}
