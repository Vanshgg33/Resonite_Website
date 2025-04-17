package com.spring.repo;

import com.spring.Model.Course_Fees_INFO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeesRepo extends JpaRepository<Course_Fees_INFO, Integer> {

    @Query("SELECT c FROM Course_Fees_INFO c JOIN FETCH c.user")
    List<Course_Fees_INFO> findAllUserFees();  // Fixed method name

    boolean existsByName(String name);  // Fixed method name

    List<Course_Fees_INFO> getByName(String name);

    @Query("SELECT c FROM Course_Fees_INFO c WHERE c.FeePaid > c.Total_Fees * 0.5")
    List<Course_Fees_INFO> paidHalf();

}
