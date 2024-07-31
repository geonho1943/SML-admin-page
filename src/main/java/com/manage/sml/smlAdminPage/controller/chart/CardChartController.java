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

    @GetMapping("/check-count/day")
    public List<CardEventCount> getCheckCountInfoByDay(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return cardChartService.getCardCountByHour("check", startTime, endTime);
    }

    @GetMapping("/create-count/day")
    public List<CardEventCount> getCreateCountInfoByDay(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return cardChartService.getCardCountByHour("create", startTime, endTime);
    }

    @GetMapping("/delete-count/day")
    public List<CardEventCount> getDeleteCountInfoByDay(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return cardChartService.getCardCountByHour("delete", startTime, endTime);
    }

    @GetMapping("/deactivate-count/day")
    public List<CardEventCount> getDeactivateCountInfoByDay(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return cardChartService.getCardCountByHour("deactivate", startTime, endTime);
    }

    @GetMapping("/check-count/week")
    public List<CardEventCount> getCheckCountInfoByWeek(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusWeeks(1);
        return cardChartService.getCardCountByDay("check",startTime, endTime);
    }

    @GetMapping("/create-count/week")
    public List<CardEventCount> getCreateCountInfoByWeek(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusWeeks(1);
        return cardChartService.getCardCountByDay("create",startTime, endTime);
    }

    @GetMapping("/delete-count/week")
    public List<CardEventCount> getDeleteCountInfoByWeek(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusWeeks(1);
        return cardChartService.getCardCountByDay("delete",startTime, endTime);
    }

    @GetMapping("/deactivate-count/week")
    public List<CardEventCount> getDeactivateCountInfoByWeek(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusWeeks(1);
        return cardChartService.getCardCountByDay("deactivate",startTime, endTime);
    }

    @GetMapping("/check-count/month")
    public List<CardEventCount> getCheckCountInfoByMonth(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusMonths(1);
        return cardChartService.getCardCountByDay("check", startTime, endTime);
    }

    @GetMapping("/create-count/month")
    public List<CardEventCount> getCreateCountInfoByMonth(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusMonths(1);
        return cardChartService.getCardCountByDay("create", startTime, endTime);
    }

    @GetMapping("/delete-count/month")
    public List<CardEventCount> getDeleteCountInfoByMonth(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusMonths(1);
        return cardChartService.getCardCountByDay("delete", startTime, endTime);
    }

    @GetMapping("/deactivate-count/month")
    public List<CardEventCount> getDeactivateCountInfoByMonth(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusMonths(1);
        return cardChartService.getCardCountByDay("deactivate", startTime, endTime);
    }

}
