package com.manage.sml.smlAdminPage.service.gendummydata;

import com.manage.sml.smlAdminPage.entity.EventLog;
import com.manage.sml.smlAdminPage.repository.LogRepository;
import com.manage.sml.smlAdminPage.service.card.CardLogToCountConverter;
import com.manage.sml.smlAdminPage.service.playlist.PlaylistLogToCountConverter;
import com.manage.sml.smlAdminPage.service.user.UserLogToCountConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DummyDataGenerator {

    @Autowired
    private LogRepository logRepository;
    @Autowired
    UserLogToCountConverter userLogToCountConverter;
    @Autowired
    CardLogToCountConverter cardLogToCountConverter;
    @Autowired
    PlaylistLogToCountConverter playlistLogToCountConverter;

    public void generateDummyData() throws Exception {
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusMonths(1);

        String[] eventTypes = {
            "user/login", "user/register", "user/unregister", "user/deactivate",
            "card/check", "card/create", "card/delete", "card/deactivate",
            "playlist/check", "playlist/create", "playlist/delete", "playlist/deactivate"
        };

        LocalDateTime currentHour = startTime.truncatedTo(ChronoUnit.HOURS);
        while (!currentHour.isAfter(endTime)) {
            LocalDateTime nextHour = currentHour.plusHours(1);
            processHourLogs(currentHour, nextHour, eventTypes);
            currentHour = nextHour;
        }
    }

    private void processHourLogs(LocalDateTime startTime, LocalDateTime endTime, String[] eventTypes) {
        List<EventLog> eventLogs = logRepository.findAllByActiveRegBetween(startTime, endTime);

        Map<String, Integer> eventTypeCounts = new HashMap<>();
        for (String eventType : eventTypes) {
            eventTypeCounts.put(eventType, 0);
        }

        // Count events
        for (EventLog eventLog : eventLogs) {
            String activeType = eventLog.getActiveType();
            eventTypeCounts.put(activeType, eventTypeCounts.getOrDefault(activeType, 0) + 1);
        }

        // 도메인별 카운트 저장
        saveCounts(endTime, eventTypeCounts);
    }

    private void saveCounts(LocalDateTime time, Map<String, Integer> eventTypeCounts) {
        // 도메인별 카운트 저장
        userLogToCountConverter.saveLoginCount(time, eventTypeCounts.get("user/login"));
        userLogToCountConverter.saveRegisterCount(time, eventTypeCounts.get("user/register"));
        userLogToCountConverter.saveUnregisterCount(time, eventTypeCounts.get("user/unregister"));
        userLogToCountConverter.saveDeactivateCount(time, eventTypeCounts.get("user/deactivate"));
        //Card-
        cardLogToCountConverter.saveCheckCount(time, eventTypeCounts.get("card/check"));
        cardLogToCountConverter.saveCreateCount(time, eventTypeCounts.get("card/create"));
        cardLogToCountConverter.saveDeleteCount(time, eventTypeCounts.get("card/delete"));
        cardLogToCountConverter.saveDeactivateCount(time, eventTypeCounts.get("card/deactivate"));
        //Playlist
        playlistLogToCountConverter.saveCheckCount(time, eventTypeCounts.get("playlist/check"));
        playlistLogToCountConverter.saveCreateCount(time, eventTypeCounts.get("playlist/create"));
        playlistLogToCountConverter.saveDeleteCount(time, eventTypeCounts.get("playlist/delete"));
        playlistLogToCountConverter.saveDeactivateCount(time, eventTypeCounts.get("playlist/deactivate"));
    }
}
