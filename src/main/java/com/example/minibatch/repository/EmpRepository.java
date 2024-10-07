package com.example.minibatch.repository;

import com.example.minibatch.entity.Emp;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EmpRepository extends JpaRepository<Emp, Long> {
    Optional<Emp> findByEmpId(Long empId);


    @Modifying
    @Query("update Emp e set e.empNum = :empNum where e.empId = :empId")
    void update(Long empId,Long empNum);

}
