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

    public List<UserEventCount> getRegisterCountByHour(LocalDateTime startTime, LocalDateTime endTime) {
        return userRepository.findByActionAndChartTimeBetween("register", startTime, endTime);
    }

    public List<UserEventCount> getResignCountByHour(LocalDateTime startTime, LocalDateTime endTime) {
        return userRepository.findByActionAndChartTimeBetween("unregister", startTime, endTime);
    }

    public List<UserEventCount> getdeactiveCountByHour(LocalDateTime startTime, LocalDateTime endTime) {
        return userRepository.findByActionAndChartTimeBetween("deactivate", startTime, endTime);
    }

}