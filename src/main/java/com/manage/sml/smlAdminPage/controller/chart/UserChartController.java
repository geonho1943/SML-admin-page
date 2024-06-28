package com.manage.sml.smlAdminPage.controller.chart;

import com.manage.sml.smlAdminPage.entity.DateTimeTemp;
import com.manage.sml.smlAdminPage.service.UserChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("chart-info")
public class UserChartController {

    @Autowired
    UserChartService userChartService;

    @GetMapping("/loginCountByDay")
    public List<DateTimeTemp> getLoginInfoByDay() {
        // 일일 모든 사용자의 로그인 횟수 총합
        return userChartService.getLoginCountByDay();
    }
}
