package com.manage.sml.smlAdminPage.controller.chart;

import com.manage.sml.smlAdminPage.entity.UserEventCount;
import com.manage.sml.smlAdminPage.service.user.UserChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("chart-info")
public class UserChartController {

    @Autowired
    UserChartService userChartService;

    //TODO: 중복코드 정리
    //TODO: url 파라미터 분리
    //TODO: 특정 시, 일, 월 파라미터 대응
    @GetMapping("/allLoginCountByHour")
    public List<UserEventCount> getLoginCountInfoByHour() {
        //모든 사용자의 시간별 로그인 횟수
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusHours(24);
        return userChartService.getLoginCountByHour(startTime, endTime);
    }

    @GetMapping("/allJoinCountByHour")
    public List<UserEventCount> getJoinCountInfoByHour() {
        //모든 사용자의 시간별 회원가입 횟수
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusHours(24);
        return userChartService.getJoinCountByHour(startTime, endTime);
    }

    @GetMapping("/allResignCountByHour")
    public List<UserEventCount> getResignCountInfoByHour() {
        //모든 사용자의 시간별 회원가입 횟수
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusHours(24);
        return userChartService.getResignCountByHour(startTime, endTime);
    }

    @GetMapping("/allBlockCountByHour")
    public List<UserEventCount> getBlockCountInfoByHour() {
        //모든 사용자의 시간별 회원가입 횟수
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusHours(24);
        return userChartService.getBlockCountByHour(startTime, endTime);
    }

}
