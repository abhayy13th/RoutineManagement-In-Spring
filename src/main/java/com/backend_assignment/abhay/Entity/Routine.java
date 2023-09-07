package com.backend_assignment.abhay.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
@Getter
@Setter
@Entity
@Table
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long r_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate routineDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String room;
    private String subject;

    @ManyToOne // Many routines belong to one teacher
    private Teacher teacher;

    @ManyToOne // One routine belong to one group
    private StudentGroup studentGroup;
}