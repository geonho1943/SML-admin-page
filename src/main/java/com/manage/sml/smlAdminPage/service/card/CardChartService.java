package com.manage.sml.smlAdminPage.service.card;

import com.manage.sml.smlAdminPage.entity.CardEventCount;
import com.manage.sml.smlAdminPage.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CardChartService {

    @Autowired
    private CardRepository cardRepository;

    public List<CardEventCount> getCheckCountByHour(LocalDateTime startTime, LocalDateTime endTime) {
        return cardRepository.findByActionAndChartTimeBetween("check", startTime, endTime);
    }

    public List<CardEventCount> getCreateCountByHour(LocalDateTime startTime, LocalDateTime endTime) {
        return cardRepository.findByActionAndChartTimeBetween("create", startTime, endTime);
    }

    public List<CardEventCount> getDeleteCountByHour(LocalDateTime startTime, LocalDateTime endTime) {
        return cardRepository.findByActionAndChartTimeBetween("delete", startTime, endTime);
    }

    public List<CardEventCount> getDeactivateCountByHour(LocalDateTime startTime, LocalDateTime endTime) {
        return cardRepository.findByActionAndChartTimeBetween("deactivate", startTime, endTime);
    }
}