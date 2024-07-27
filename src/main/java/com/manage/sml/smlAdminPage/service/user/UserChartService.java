package com.manage.sml.smlAdminPage.service.user;

import com.manage.sml.smlAdminPage.entity.UserEventCount;
import com.manage.sml.smlAdminPage.entity.UserEventCount;
import com.manage.sml.smlAdminPage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserChartService {

    @Autowired
    UserRepository userRepository;

    public List<UserEventCount> getUserCountByDay(String action, LocalDateTime startTime, LocalDateTime endTime) {
        return userRepository.findByActionAndChartTimeBetween("register", startTime, endTime);
    }

    public List<UserEventCount> getUserCountByWeek(String action, LocalDateTime startTime, LocalDateTime endTime) {
        List<UserEventCount> actionDataByHour = userRepository.findByActionAndChartTimeBetween(action , startTime, endTime);

        //date 기준 count 누적합데이터를 Map으로 생성
        Map<LocalDate, Integer> dailyCountMap = new HashMap<>();
        for (UserEventCount event : actionDataByHour) {
            LocalDate date = event.getChartTime().toLocalDate();
            int currentCount = event.getActiveCount();

            if (dailyCountMap.containsKey(date)) {
                dailyCountMap.put(date, dailyCountMap.get(date) + currentCount);
            } else {
                dailyCountMap.put(date, currentCount);
            }
        }

        List<UserEventCount> dailyData = new ArrayList<>();
        for (Map.Entry<LocalDate, Integer> entry : dailyCountMap.entrySet()) {
            LocalDateTime dateTime = entry.getKey().atStartOfDay();
            int count = entry.getValue();
            UserEventCount dailyEventCount = new UserEventCount(action, dateTime, count);
            dailyData.add(dailyEventCount);
        }

        // 날짜 순으로 정렬
        dailyData.sort(Comparator.comparing(UserEventCount::getChartTime));

        return dailyData;
    }


}