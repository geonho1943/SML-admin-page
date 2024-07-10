package com.manage.sml.smlAdminPage.service;

import com.manage.sml.smlAdminPage.entity.EventLog;
import com.manage.sml.smlAdminPage.repository.LogRepository;
import com.manage.sml.smlAdminPage.service.user.UserLogToCountConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LogCount {

    @Autowired
    private LogRepository logRepository;
    @Autowired
    UserLogToCountConverter userLogToCountConverter;

    @Scheduled(cron = "0 0 * * * *")
    public void arrangeForLogByHour() throws Exception {
        //매시 정각 스케줄
        //시간단위 로그의 카운트 데이터화
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusHours(1);
        List<EventLog> eventLogByLastHour = new ArrayList<>();
        eventLogByLastHour = logRepository.findByActiveRegBetween(startTime, endTime);
        // 1시간 로그 데이터를 active_type 기준으로 각각 카운팅
        int login = 0, join = 0, resign = 0, block = 0;
        for (int i = 0; i < eventLogByLastHour.size(); i++) {
            String activeType = eventLogByLastHour.get(i).getActiveType();
            switch (activeType){
                case "user/login": login++;
                    break;
                case "user/join": join++;
                    break;
                case "user/resign": resign++;
                    break;
                case "user/block": block++;
                    break;
                default:
//                    throw new Exception("1개의 카운트되지않은 로그 idx: "+ eventLogByLastHour.get(i).getEventIdx()+"가 있음.");
                    break;
            }
        }
        // 도메인별 카운트 저장
        userLogToCountConverter.saveLoginCount(endTime, login);
        userLogToCountConverter.saveJoinCount(endTime, join);
        userLogToCountConverter.saveResignCount(endTime, resign);
        userLogToCountConverter.saveBlockCount(endTime, block);
        //Card-

        //Playlist
    }

    //TODO: 일별 스케줄
//    @Scheduled(cron = "0 0 0 * * *")
//    public void arrangeForLogByDay() {
        //매일 정시 스케줄
        //매일단위 로그의 카운트 데이터화
        //User-
//        userChartService.getLoginCountByDay();
//        userChartService.getjoinCountByDay();
//        userChartService.getResignCountByDay();
//        userChartService.getBlockCountByDay(); 유저 비활성화

        //Card-

        //Playlist
//    }

}
