package com.spring.repo;

import com.spring.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    @Query("select e from Employee e JOIN fetch e.user")
    List<Employee> findallemployeewithuser();


}
