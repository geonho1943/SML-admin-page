package com.manage.sml.smlAdminPage.service.playlist;

import com.manage.sml.smlAdminPage.entity.PlaylistEventCount;
import com.manage.sml.smlAdminPage.entity.PlaylistEventCount;
import com.manage.sml.smlAdminPage.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class PlaylistChartService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public List<PlaylistEventCount> getPlaylistCountByDay(String action, LocalDateTime startTime, LocalDateTime endTime) {
        return playlistRepository.findByActionAndChartTimeBetween(action , startTime, endTime);
    }

    public List<PlaylistEventCount> getPlaylistCountByWeek(String action, LocalDateTime startTime, LocalDateTime endTime) {

        List<PlaylistEventCount> actionDataByHour = playlistRepository.findByActionAndChartTimeBetween(action , startTime, endTime);

        //date 기준 count 누적합데이터를 Map으로 생성
        Map<LocalDate, Integer> dailyCountMap = new HashMap<>();
        for (PlaylistEventCount event : actionDataByHour) {
            LocalDate date = event.getChartTime().toLocalDate();
            int currentCount = event.getActiveCount();

            if (dailyCountMap.containsKey(date)) {
                dailyCountMap.put(date, dailyCountMap.get(date) + currentCount);
            } else {
                dailyCountMap.put(date, currentCount);
            }
        }

        List<PlaylistEventCount> dailyData = new ArrayList<>();
        for (Map.Entry<LocalDate, Integer> entry : dailyCountMap.entrySet()) {
            LocalDateTime dateTime = entry.getKey().atStartOfDay();
            int count = entry.getValue();
            PlaylistEventCount dailyEventCount = new PlaylistEventCount(action, dateTime, count);
            dailyData.add(dailyEventCount);
        }

        // 날짜 순으로 정렬
        dailyData.sort(Comparator.comparing(PlaylistEventCount::getChartTime));

        return dailyData;
    }



}