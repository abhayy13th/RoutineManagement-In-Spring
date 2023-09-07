package com.backend_assignment.abhay.Entity.Enum;

import lombok.Getter;

@Getter
public enum Faculty {
    MULTIMEDIA("M", "Multimedia"),
    COMPUTING("C", "Computing"),
    NETWORKING("N", "Networking");

    private final String facultyCode;
    private final String facultyDescription;

    Faculty(String facultyCode, String facultyDescription) {
        this.facultyCode = facultyCode;
        this.facultyDescription = facultyDescription;
    }
}
