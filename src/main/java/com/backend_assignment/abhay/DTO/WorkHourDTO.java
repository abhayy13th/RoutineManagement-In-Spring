package com.backend_assignment.abhay.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class WorkHourDTO {
    private String teacherName;
    private LocalDate startDate;
    private LocalDate endDate;
}
