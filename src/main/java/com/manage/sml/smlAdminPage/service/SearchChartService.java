package com.manage.sml.smlAdminPage.service;

import com.manage.sml.smlAdminPage.entity.EventLog;
import com.manage.sml.smlAdminPage.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class SearchChartService {

    @Autowired
    LogRepository logRepository;

    public Map<LocalDateTime, Map<String, Integer>> getCountByIdxToHour(
            Integer objIdx, String activeType, LocalDateTime startTime, LocalDateTime endTime) {
        List<EventLog> eventLogList = logRepository.findByUserIdxAndActiveTypeStartingWithAndActiveRegBetween(
                objIdx, activeType, startTime, endTime);
        // 시간별 카운트 맵 생성
        Map<LocalDateTime, Map<String, Integer>> CountMapByHour = new HashMap<>();
        // 데이터를 시간별로 누적
        for (EventLog event : eventLogList) {
            LocalDateTime hour = event.getActiveReg().withMinute(0).withSecond(0).withNano(0); // 시간 단위로 그룹화
            String eventType = event.getActiveType();
            CountMapByHour.putIfAbsent(hour, new HashMap<>());
            Map<String, Integer> typeCountMap = CountMapByHour.get(hour);
            typeCountMap.put(eventType, typeCountMap.getOrDefault(eventType, 0) + 1);
        }
        return CountMapByHour;
    }

    public  Map<LocalDate, Map<String, Integer>> getCountByIdxToDay(
            Integer objIdx, String activeType, LocalDateTime startTime, LocalDateTime endTime) {
        List<EventLog> eventLogList = logRepository.findByUserIdxAndActiveTypeStartingWithAndActiveRegBetween(
                objIdx, activeType, startTime, endTime);
        Map<LocalDate, Map<String, Integer>> CountByDay = new HashMap<>();

        for (EventLog event : eventLogList) {
            LocalDate date = event.getActiveReg().toLocalDate();
            String eventType = event.getActiveType();
            CountByDay.putIfAbsent(date, new HashMap<>());
            Map<String, Integer> typeCountMap = CountByDay.get(date);
            typeCountMap.put(eventType, typeCountMap.getOrDefault(eventType, 0) + 1);
        }
        return CountByDay;
    }
}
