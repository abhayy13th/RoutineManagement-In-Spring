package com.backend_assignment.abhay.Entity.Enum;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("A", "Active"),
    DELETED("X", "Deleted");

    private final String statusCode;
    private final String statusDescription;

    Status(String statusCode, String statusDescription) {
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
    }

}
