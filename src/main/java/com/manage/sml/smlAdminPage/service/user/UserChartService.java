package com.manage.sml.smlAdminPage.service.user;

import com.manage.sml.smlAdminPage.entity.UserEventCount;
import com.manage.sml.smlAdminPage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserChartService {

    @Autowired
    UserRepository userRepository;

    public List<UserEventCount> getLoginCountByHour(LocalDateTime startTime, LocalDateTime endTime) {
        return userRepository.findByActionAndChartTimeBetween("login", startTime, endTime);
    }

    public List<UserEventCount> getJoinCountByHour(LocalDateTime startTime, LocalDateTime endTime) {
        return userRepository.findByActionAndChartTimeBetween("join", startTime, endTime);
    }

    public List<UserEventCount> getResignCountByHour(LocalDateTime startTime, LocalDateTime endTime) {
        return userRepository.findByActionAndChartTimeBetween("resign", startTime, endTime);
    }

    public List<UserEventCount> getBlockCountByHour(LocalDateTime startTime, LocalDateTime endTime) {
        return userRepository.findByActionAndChartTimeBetween("Block", startTime, endTime);
    }

}