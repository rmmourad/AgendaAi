package com.agendaai.schedule.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendaai.schedule.models.ScheduleModel;
import com.agendaai.schedule.repositories.ScheduleRepository;

import jakarta.transaction.Transactional;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository sRepository;

    @Transactional
    public ScheduleModel save(ScheduleModel sModel) {
        return sRepository.save(sModel);
    }

    @Transactional
    public ScheduleModel updateSchedule(UUID sID, ScheduleModel sModel) {
        ScheduleModel existingSchedule = sRepository.findById(sID).orElse(null);
        if(existingSchedule != null) {
            existingSchedule.setScheduleDate(sModel.getScheduleDate());
            existingSchedule.setScheduleTime(sModel.getScheduleTime());
            
            return sRepository.save(existingSchedule);
        }

        return null;
    }

    public ScheduleModel getScheduleById(UUID sID) {
        return sRepository.findById(sID).orElse(null);
    }

    public void deleteScheduleById(UUID sID) {
        sRepository.deleteById(sID);
    }

}
