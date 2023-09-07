package com.backend_assignment.abhay.Repository;

import com.backend_assignment.abhay.Entity.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<StudentGroup, Long> {
}
