package com.backend_assignment.abhay.Repository;

import com.backend_assignment.abhay.Entity.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {
    @Query("SELECT (SUM(FUNCTION('TIME_TO_SEC', r.endTime) - FUNCTION('TIME_TO_SEC', r.startTime)) / 3600) " +
            "FROM Routine r " +
            "JOIN r.teacher t " +
            "WHERE t.name = :teacherName " +
            "AND r.routineDate BETWEEN :startDate AND :endDate")
    Integer getWorkHours(
            @Param("teacherName") String teacherName,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    @Query("SELECT (SUM(FUNCTION('TIME_TO_SEC', r.endTime) - FUNCTION('TIME_TO_SEC', r.startTime)) / 3600) " +
            "FROM Routine r " +
            "WHERE r.studentGroup.id = :groupId")
    Integer getGroupWorkHours(
            @Param("groupId")
            Long groupId);
}

