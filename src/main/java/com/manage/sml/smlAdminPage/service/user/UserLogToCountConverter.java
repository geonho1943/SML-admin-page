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

    public void saveLoginCount(LocalDateTime endTime, int login) {
        userRepository.save(new UserEventCount("login", endTime, login));
    }

    public void saveJoinCount(LocalDateTime endTime, int join) {
        userRepository.save(new UserEventCount("join", endTime, join));
    }

    public void saveResignCount(LocalDateTime endTime, int resign) {
        userRepository.save(new UserEventCount("resign", endTime, resign));
    }

    public void saveBlockCount(LocalDateTime endTime, int block) {
        userRepository.save(new UserEventCount("block", endTime, block));
    }

}
