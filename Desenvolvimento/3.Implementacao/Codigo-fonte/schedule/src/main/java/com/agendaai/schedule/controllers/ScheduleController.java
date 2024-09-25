package com.agendaai.schedule.controllers;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agendaai.schedule.dtos.ScheduleRecordDto;
import com.agendaai.schedule.models.ScheduleModel;
import com.agendaai.schedule.services.ScheduleService;

import jakarta.validation.Valid;

@RestController
public class ScheduleController {
    final ScheduleService sService;

    public ScheduleController(ScheduleService sService) {
        this.sService = sService;
    }

    @PostMapping("/schedule")
    public ResponseEntity<ScheduleModel> saveSchedule(@RequestBody @Valid ScheduleRecordDto sDTO) {
        ScheduleModel sModel = new ScheduleModel();
        BeanUtils.copyProperties(sDTO, sModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(sService.save(sModel));
    }

    @GetMapping("/schedule/{scheduleId}")
    public ResponseEntity<ScheduleModel> getScheduleById(@PathVariable UUID scheduleId) {
        ScheduleModel sModel = sService.getScheduleById(scheduleId);
        if(sModel != null)
            return ResponseEntity.ok(sModel);
        
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/schedule/{scheduleId}")
    public ResponseEntity<ScheduleModel> updateScheduleById(@PathVariable UUID scheduleId, @RequestBody ScheduleModel sModel) {
        ScheduleModel nSchedule = sService.updateSchedule(scheduleId, sModel);
        return ResponseEntity.ok(nSchedule);
    }

    @DeleteMapping("/schedule/{scheduleId}")
    public ResponseEntity<ScheduleModel> deleteScheduleById(@PathVariable UUID scheduleId) {
        sService.deleteScheduleById(scheduleId);
        return ResponseEntity.noContent().build();
    }

}
