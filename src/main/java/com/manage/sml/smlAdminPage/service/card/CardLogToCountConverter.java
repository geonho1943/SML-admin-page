package com.manage.sml.smlAdminPage.service.card;

import com.manage.sml.smlAdminPage.entity.CardEventCount;

import com.manage.sml.smlAdminPage.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CardLogToCountConverter {

    @Autowired
    private CardRepository cardRepository;

    public void saveCheckCount(LocalDateTime endTime, int cardCheck) {
        cardRepository.save(new CardEventCount("check", endTime, cardCheck));
    }

    public void saveCreateCount(LocalDateTime endTime, int cardCreate) {
        cardRepository.save(new CardEventCount("create", endTime, cardCreate));
    }

    public void saveDeleteCount(LocalDateTime endTime, int cardDelete) {
        cardRepository.save(new CardEventCount("delete", endTime, cardDelete));
    }

    public void saveDeactivateCount(LocalDateTime endTime, int cardDeactivate) {
        cardRepository.save(new CardEventCount("deactivate", endTime, cardDeactivate));
    }
}
