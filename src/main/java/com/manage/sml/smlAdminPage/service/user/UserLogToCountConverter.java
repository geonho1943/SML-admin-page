package com.manage.sml.smlAdminPage.service.user;

import com.manage.sml.smlAdminPage.entity.UserEventCount;
import com.manage.sml.smlAdminPage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserLogToCountConverter {

    @Autowired
    private UserRepository userRepository;

    public void saveLoginCount(LocalDateTime endTime, int userLogin) {
        userRepository.save(new UserEventCount("login", endTime, userLogin));
    }

    public void saveRegisterCount(LocalDateTime endTime, int userJoin) {
        userRepository.save(new UserEventCount("register", endTime, userJoin));
    }

    public void saveUnregisterCount(LocalDateTime endTime, int userResign) {
        userRepository.save(new UserEventCount("unregister", endTime, userResign));
    }

    public void saveDeactivateCount(LocalDateTime endTime, int userBlock) {
        userRepository.save(new UserEventCount("deactivate", endTime, userBlock));
    }
}
