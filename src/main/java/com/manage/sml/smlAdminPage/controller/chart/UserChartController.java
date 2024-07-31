package com.manage.sml.smlAdminPage.controller.chart;

import com.manage.sml.smlAdminPage.entity.UserEventCount;
import com.manage.sml.smlAdminPage.service.user.UserChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/chart/users")
public class UserChartController {

    @Autowired
    UserChartService userChartService;

    @GetMapping("/login-count/day")
    public List<UserEventCount> getLoginCountInfoByDay(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return userChartService.getUserCountByHour("login", startTime, endTime);
    }

    @GetMapping("/register-count/day")
    public List<UserEventCount> getRegisterCountInfoByDay(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return userChartService.getUserCountByHour("register", startTime, endTime);
    }

    @GetMapping("/unregister-count/day")
    public List<UserEventCount> getResignCountInfoByDay(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return userChartService.getUserCountByHour("unregister", startTime, endTime);
    }

    @GetMapping("/deactivate-count/day")
    public List<UserEventCount> getBlockCountInfoByDay(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return userChartService.getUserCountByHour("deactivate", startTime, endTime);
    }

    @GetMapping("/login-count/week")
    public List<UserEventCount> getLoginCountInfoByWeek(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusWeeks(1);
        return userChartService.getUserCountByDay("login", startTime, endTime);
    }

    @GetMapping("/register-count/week")
    public List<UserEventCount> getRegisterCountInfoByWeek(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusWeeks(1);
        return userChartService.getUserCountByDay("register", startTime, endTime);
    }

    @GetMapping("/unregister-count/week")
    public List<UserEventCount> getUnregisterCountInfoByWeek(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusWeeks(1);
        return userChartService.getUserCountByDay("unregister", startTime, endTime);
    }

    @GetMapping("/deactivate-count/week")
    public List<UserEventCount> getBlockCountInfoByWeek(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusWeeks(1);
        return userChartService.getUserCountByDay("deactivate", startTime, endTime);
    }

    @GetMapping("/login-count/month")
    public List<UserEventCount> getLoginCountInfoByMonth(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusMonths(1);
        return userChartService.getUserCountByDay("login", startTime, endTime);
    }

    @GetMapping("/register-count/month")
    public List<UserEventCount> getRegisterCountInfoByMonth(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusMonths(1);
        return userChartService.getUserCountByDay("register", startTime, endTime);
    }

    @GetMapping("/unregister-count/month")
    public List<UserEventCount> getUnregisterCountInfoByMonth(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusMonths(1);
        return userChartService.getUserCountByDay("unregister", startTime, endTime);
    }

    @GetMapping("/deactivate-count/month")
    public List<UserEventCount> getBlockCountInfoByMonth(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusMonths(1);
        return userChartService.getUserCountByDay("deactivate", startTime, endTime);
    }

}
