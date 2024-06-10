package com.agendaai.schedule.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendaai.schedule.models.ScheduleModel;

public interface ScheduleRepository extends JpaRepository<ScheduleModel, UUID> {

}
