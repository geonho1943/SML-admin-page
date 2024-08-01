package com.manage.sml.smlAdminPage.controller.chart;

import com.manage.sml.smlAdminPage.entity.EventLog;
import com.manage.sml.smlAdminPage.service.SearchChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/api/chart/search")
public class SearchChartController {
    @Autowired
    SearchChartService searchChartService;

    @GetMapping("/{domain}/{chart-type}")
    public ResponseEntity<List<EventLog>> getChartByIdx(
            @PathVariable("domain") String domain,
            @PathVariable("chart-type") String type,
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime,
            @RequestParam(value = "objectIdx") Integer objIdx
    ) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        List<EventLog> eventLog;
        try {
            if (objIdx == null) throw new IllegalArgumentException("objectIdx 파라미터가 필요합니다.");
            // 각 상황에 맞는 메서드에 요청
            if ("user".equals(domain) || "card".equals(domain) || "playlist".equals(domain)) {
                if ("week".equals(type) || "month".equals(type)) {
                    eventLog = searchChartService.getCountByIdxToHour(objIdx, domain, type, startTime, endTime);
                }else if ("day".equals(type)) {
                    eventLog = searchChartService.getCountByIdxToDay(objIdx, domain, type, startTime, endTime);
                } else {
                    throw new IllegalArgumentException("유효하지 않은 chart-type 값입니다.");
                }
            } else {
                throw new IllegalArgumentException("유효하지 않은 domain 값입니다.");
            }
            return ResponseEntity.ok(eventLog);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            System.out.println("예상하지못한 오류: " + e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }
}
