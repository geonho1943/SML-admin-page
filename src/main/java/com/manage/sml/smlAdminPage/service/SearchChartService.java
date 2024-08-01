package com.manage.sml.smlAdminPage.service;

import com.manage.sml.smlAdminPage.entity.EventLog;
import com.manage.sml.smlAdminPage.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class SearchChartService {

    @Autowired
    LogRepository logRepository;

    public List<EventLog> getCountByIdxToHour(
            Integer objIdx, String activeType, String type, LocalDateTime startTime, LocalDateTime endTime
    ) {
        if (Objects.equals(type, "week") || Objects.equals(type, "month")){
            System.out.println(type);
            return logRepository.findByUserIdxAndActiveTypeStartingWithAndActiveRegBetween(
                    //StartingWith sql-varchar의 % 연산자
                    objIdx, activeType, startTime, endTime);
        }else return null;
    }

    public List<EventLog> getCountByIdxToDay(
            Integer objIdx, String activeType, String type, LocalDateTime startTime, LocalDateTime endTime
    ) {
        if (Objects.equals(type, "week")) {
//            type.equals("day") 는 null예외가 발생할 수 있음
            System.out.println(type);
            return logRepository.findByUserIdxAndActiveTypeStartingWithAndActiveRegBetween(
                    objIdx, activeType, startTime, endTime);
        }else return null;
    }
}
