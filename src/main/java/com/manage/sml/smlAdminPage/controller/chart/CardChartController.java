package com.manage.sml.smlAdminPage.controller.chart;

import com.manage.sml.smlAdminPage.entity.CardEventCount;
import com.manage.sml.smlAdminPage.service.card.CardChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/chart/cards")
public class CardChartController {

    @Autowired
    CardChartService cardChartService;

    @GetMapping("/check-count/hour")
    public List<CardEventCount> getCheckCountInfoByHour(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return cardChartService.getCheckCountByHour(startTime, endTime);
    }

    @GetMapping("/create-count/hour")
    public List<CardEventCount> getCreateCountInfoByHour(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return cardChartService.getCreateCountByHour(startTime, endTime);
    }

    @GetMapping("/delete-count/hour")
    public List<CardEventCount> getDeleteCountInfoByHour(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return cardChartService.getDeleteCountByHour(startTime, endTime);
    }

    @GetMapping("/deactivate-count/hour")
    public List<CardEventCount> getDeactivateCountInfoByHour(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return cardChartService.getDeactivateCountByHour(startTime, endTime);
    }


}
