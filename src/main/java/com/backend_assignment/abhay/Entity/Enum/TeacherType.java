package com.backend_assignment.abhay.Entity.Enum;

import lombok.Getter;

@Getter
public enum TeacherType {
    FULL_TIME("F", "Full-Time"),
    PART_TIME("P", "Part-Time");

    private final String typeCode;
    private final String typeDescription;

    TeacherType(String typeCode, String typeDescription) {
        this.typeCode = typeCode;
        this.typeDescription = typeDescription;
    }
}
