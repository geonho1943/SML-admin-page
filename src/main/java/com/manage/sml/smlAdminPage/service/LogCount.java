package com.manage.sml.smlAdminPage.service;

import com.manage.sml.smlAdminPage.entity.EventLog;
import com.manage.sml.smlAdminPage.repository.LogRepository;
import com.manage.sml.smlAdminPage.service.card.CardLogToCountConverter;
import com.manage.sml.smlAdminPage.service.playlist.PlaylistLogToCountConverter;
import com.manage.sml.smlAdminPage.service.user.UserLogToCountConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class LogCount {

    @Autowired
    private LogRepository logRepository;
    @Autowired
    UserLogToCountConverter userLogToCountConverter;
    @Autowired
    CardLogToCountConverter cardLogToCountConverter;
    @Autowired
    PlaylistLogToCountConverter playlistLogToCountConverter;

    @Scheduled(cron = "0 0 * * * ?")
    public void arrangeForLogByHour() throws Exception {
        //매시 정각 스케줄
        //시간단위 로그의 카운트 데이터화
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusHours(1);
        List<EventLog> eventLogByLastHour;
        eventLogByLastHour = logRepository.findAllByActiveRegBetween(startTime, endTime);
        // 1시간 로그 데이터를 active_type 기준으로 각각 카운팅
        int userLogin = 0;
        int userJoin = 0;
        int userResign = 0;
        int userBlock = 0;

        int cardCheck = 0;
        int cardCreate = 0;
        int cardDelete = 0;
        int cardDeactive = 0;

        int playlistCheck = 0;
        int playlistCreate = 0;
        int playlistDelete = 0;
        int playlistDeactive = 0;
        for (int i = 0; i < eventLogByLastHour.size(); i++) {
            String activeType = eventLogByLastHour.get(i).getActiveType();
            switch (activeType){
                case "user/login": userLogin++;
                    break;
                case "user/join": userJoin++;
                    break;
                case "user/resign": userResign++;
                    break;
                case "user/block": userBlock++;
                    break;
                case "card/check": cardCheck++;
                    break;
                case "card/create": cardCreate++;
                    break;
                case "card/delete": cardDelete++;
                    break;
                case "card/deactive": cardDeactive++;
                    break;
                case "playlist/check": playlistCheck++;
                    break;
                case "playlist/create": playlistCreate++;
                    break;
                case "playlist/delete": playlistDelete++;
                    break;
                case "playlist/deactive": playlistDeactive++;
                    break;
                default:
                    System.out.println("1개의 카운트되지않은 로그 idx: " + eventLogByLastHour.get(i).getEventIdx() + "가 있음.");
                    break;
            }
        }
        // 도메인별 카운트 저장
        userLogToCountConverter.saveLoginCount(endTime, userLogin);
        userLogToCountConverter.saveJoinCount(endTime, userJoin);
        userLogToCountConverter.saveResignCount(endTime, userResign);
        userLogToCountConverter.saveBlockCount(endTime, userBlock);
        //Card-
        cardLogToCountConverter.saveCheckCount(endTime, cardCheck);
        cardLogToCountConverter.saveCreateCount(endTime, cardCreate);
        cardLogToCountConverter.saveDeleteCount(endTime, cardDelete);
        cardLogToCountConverter.saveDeactiveCount(endTime, cardDeactive);
        //Playlist
        playlistLogToCountConverter.saveCheckCount(endTime, playlistCheck);
        playlistLogToCountConverter.saveCreateCount(endTime, playlistCreate);
        playlistLogToCountConverter.saveDeleteCount(endTime, playlistDelete);
        playlistLogToCountConverter.saveDeactiveCount(endTime, playlistDeactive);

    }


}
