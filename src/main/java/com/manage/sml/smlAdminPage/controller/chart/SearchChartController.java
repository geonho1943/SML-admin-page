package com.manage.sml.smlAdminPage.controller.chart;

import com.manage.sml.smlAdminPage.service.SearchChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Controller
@RequestMapping("/api/chart/search")
public class SearchChartController {
    @Autowired
    SearchChartService searchChartService;

    @GetMapping("/{domain}/{chart-type}")
    public ResponseEntity<?> getChartByIdx(
            @PathVariable("domain") String domain,
            @PathVariable("chart-type") String type,
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime,
            @RequestParam(value = "objectIdx") Integer objIdx) {

        try {
            if (objIdx == null) {
                throw new IllegalArgumentException("objectIdx 파라미터가 필요합니다.");
            }
            if (!"user".equals(domain) && !"card".equals(domain) && !"playlist".equals(domain)) {
                throw new IllegalArgumentException("유효하지 않은 domain 값입니다.");
            }
            if (endTime == null) {
                endTime = LocalDateTime.now();
            }

            LocalDateTime startTime;
            switch (type) {
                case "week":
                    // week, month는 하루 단위로 차트를 뽑아야 함 > xxxToDay()
                    startTime = endTime.minusDays(7);
                    Map<LocalDate, Map<String, Integer>> eventLogByWeek = searchChartService.getCountByIdxToDay(objIdx, domain, startTime, endTime);
                    return ResponseEntity.ok(eventLogByWeek);
                case "month":
                    startTime = endTime.minusMonths(1);
                    Map<LocalDate, Map<String, Integer>> eventLogByMonth = searchChartService.getCountByIdxToDay(objIdx, domain, startTime, endTime);
                    return ResponseEntity.ok(eventLogByMonth);
                case "day":
                    // day는 시간 단위로 차트를 뽑아야 함 > xxxToHour()
                    startTime = endTime.minusDays(1);
                    Map<LocalDateTime, Map<String, Integer>> eventLogByDay = searchChartService.getCountByIdxToHour(objIdx, domain, startTime, endTime);
                    return ResponseEntity.ok(eventLogByDay);
                default:
                    throw new IllegalArgumentException("유효하지 않은 chart-type 값입니다.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("서버 오류가 발생했습니다.");
        }
    }
}
