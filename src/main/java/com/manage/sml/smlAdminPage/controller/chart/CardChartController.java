package com.manage.sml.smlAdminPage.controller.chart;

import com.manage.sml.smlAdminPage.entity.CardEventCount;
import com.manage.sml.smlAdminPage.service.card.CardChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("chart-info")
public class CardChartController {

    @Autowired
    CardChartService cardChartService;

    @GetMapping("/allCardCheckCountByHour")
    public List<CardEventCount> getCheckCountInfoByHour() {
        //모든 카드의 시간당 조회된 횟수
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return cardChartService.getCheckCountByHour(startTime, endTime);
    }

    @GetMapping("/allCardCreateCountByHour")
    public List<CardEventCount> getCreateCountInfoByHour() {
        //모든 카드의 시간당 조회된 횟수
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return cardChartService.getCreateCountByHour(startTime, endTime);
    }
    @GetMapping("/allCardDeleteCountByHour")
    public List<CardEventCount> getDeleteCountInfoByHour() {
        //모든 카드의 시간당 조회된 횟수
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return cardChartService.getDeleteCountByHour(startTime, endTime);
    }
    @GetMapping("/allCardDeactivateCountByHour")
    public List<CardEventCount> getDeactivateCountInfoByHour() {
        //모든 카드의 시간당 조회된 횟수
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return cardChartService.getDeactivateCountByHour(startTime, endTime);
    }



}
