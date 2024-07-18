package com.manage.sml.smlAdminPage.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "card_event_count")
public class CardEventCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "count_idx")
    private int countIdx;

    @Column (name = "action")
    private String action;

    @Column (name = "chart_time")
    private LocalDateTime chartTime;

    @Column (name = "active_count")
    private int activeCount;

    public CardEventCount() {
    }

    public CardEventCount(int countIdx, String action, LocalDateTime chartTime, int activeCount) {
        this.countIdx = countIdx;
        this.action = action;
        this.chartTime = chartTime;
        this.activeCount = activeCount;
    }

    public CardEventCount(String action, LocalDateTime chartTime, int activeCount) {
        this.action = action;
        this.chartTime = chartTime;
        this.activeCount = activeCount;
    }

    public int getCountIdx() {
        return countIdx;
    }

    public String getAction() {
        return action;
    }

    public LocalDateTime getChartTime() {
        return chartTime;
    }

    public int getActiveCount() {
        return activeCount;
    }
}
