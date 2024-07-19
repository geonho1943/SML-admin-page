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

    @GetMapping("/login-count/hour")
    public List<UserEventCount> getLoginCountInfoByHour(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return userChartService.getLoginCountByHour(startTime, endTime);
    }

    @GetMapping("/register-count/hour")
    public List<UserEventCount> getRegisterCountInfoByHour(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return userChartService.getRegisterCountByHour(startTime, endTime);
    }

    @GetMapping("/unregister-count/hour")
    public List<UserEventCount> getResignCountInfoByHour(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return userChartService.getResignCountByHour(startTime, endTime);
    }

    @GetMapping("/deactive-count/hour")
    public List<UserEventCount> getBlockCountInfoByHour(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return userChartService.getdeactiveCountByHour(startTime, endTime);
    }

}
