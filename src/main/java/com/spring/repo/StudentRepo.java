package com.spring.repo;

import com.spring.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    @Query("SELECT s FROM Student s JOIN FETCH s.user")
    List<Student> findAllStudentsWithUser();
}
