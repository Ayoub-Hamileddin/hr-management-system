package com.backend.backend.repository;

import com.backend.backend.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository  extends JpaRepository<Department,Long> {
}
