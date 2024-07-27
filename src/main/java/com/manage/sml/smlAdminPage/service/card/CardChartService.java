package com.manage.sml.smlAdminPage.service.card;

import com.manage.sml.smlAdminPage.entity.CardEventCount;
import com.manage.sml.smlAdminPage.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class CardChartService {

    @Autowired
    private CardRepository cardRepository;

    public List<CardEventCount> getCardCountByDay(String action, LocalDateTime startTime, LocalDateTime endTime) {
        return cardRepository.findByActionAndChartTimeBetween(action, startTime, endTime);
    }

    public List<CardEventCount> getCardCountByWeek(String action, LocalDateTime startTime, LocalDateTime endTime) {
        // JPA 메서드 호출하여 1시간 간격의 데이터를 가져옴
        List<CardEventCount> actionDataByHour = cardRepository.findByActionAndChartTimeBetween(action, startTime, endTime);

        //date 기준 count 누적합데이터를 Map으로 생성
        Map<LocalDate, Integer> dailyCountMap = new HashMap<>();
        for (CardEventCount event : actionDataByHour) {
            LocalDate date = event.getChartTime().toLocalDate();
            int currentCount = event.getActiveCount();

            if (dailyCountMap.containsKey(date)) {
                dailyCountMap.put(date, dailyCountMap.get(date) + currentCount);
            } else {
                dailyCountMap.put(date, currentCount);
            }
        }

        List<CardEventCount> dailyData = new ArrayList<>();
        for (Map.Entry<LocalDate, Integer> entry : dailyCountMap.entrySet()) {
            LocalDateTime dateTime = entry.getKey().atStartOfDay();
            int count = entry.getValue();
            CardEventCount dailyEventCount = new CardEventCount(action, dateTime, count);
            dailyData.add(dailyEventCount);
        }

        // 날짜 순으로 정렬
        dailyData.sort(Comparator.comparing(CardEventCount::getChartTime));

        return dailyData;
    }
}