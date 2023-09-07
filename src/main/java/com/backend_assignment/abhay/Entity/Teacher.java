package com.backend_assignment.abhay.Entity;

import com.backend_assignment.abhay.Entity.Enum.Status;
import com.backend_assignment.abhay.Entity.Enum.TeacherType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherId;
    private String name;
    private String subject;
    private String email;


    private String status = Status.ACTIVE.getStatusCode();

    private String type = TeacherType.FULL_TIME.getTypeCode();



}

