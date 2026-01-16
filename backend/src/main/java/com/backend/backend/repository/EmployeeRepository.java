package com.backend.backend.repository;


import com.backend.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    @Query("Select e.user.firstName" +
            " from employee e " +
            " Where  e.name=:employeeName ")
    List<Employee> findUserFirstNameByEmployeeName(@Param("employeeName") String name);
}
