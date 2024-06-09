package com.agendaai.schedule.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public record ScheduleRecordDto(
                    @NotBlank UUID costumerID,
                    @NotBlank UUID productID,
                    @NotBlank String scheduleDate,
                    @NotBlank String scheduleTime ) {

}
