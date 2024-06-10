package com.agendaai.schedule.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_SCHEDULES")
public class ScheduleModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID scheduleID;
    private UUID costumerID;
    private UUID productID;
    private String scheduleDate;
    private String scheduleTime;

    public UUID getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(UUID scheduleID) {
        this.scheduleID = scheduleID;
    }

    public UUID getCostumerID() {
        return costumerID;
    }

    public void setCostumerID(UUID costumerID) {
        this.costumerID = costumerID;
    }

    public UUID getProductID() {
        return productID;
    }

    public void setProductID(UUID productID) {
        this.productID = productID;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }
        
}
