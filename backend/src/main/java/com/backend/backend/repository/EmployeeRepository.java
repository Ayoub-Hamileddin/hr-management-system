package com.backend.backend.repository;


import com.backend.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


//    @Query("Select e.user.firstName" +
//            " from Employee e " +
//            " Where  e.name=:employeeName ")
//    List<Employee> findUserFirstNameByEmployeeName(@Param("employeeName") String name);
}
