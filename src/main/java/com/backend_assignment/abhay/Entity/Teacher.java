package com.backend_assignment.abhay.Entity;

import com.backend_assignment.abhay.Entity.Enum.Status;
import com.backend_assignment.abhay.Entity.Enum.TeacherType;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
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
    private Long id;
    private String name;
    private String subject;
    private String email;

    @Transient
    private String status = Status.ACTIVE.getStatusCode();

    private String type = TeacherType.FULL_TIME.getTypeCode();

    public Teacher() {
    }

    public Teacher(String name, String subject, String email, String type) {
        this.name = name;
        this.subject = subject;
        this.email = email;
        this.status = Status.ACTIVE.getStatusCode();
        this.type = type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

