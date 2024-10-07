package com.example.minibatch.service;

import com.example.minibatch.entity.Emp;
import com.example.minibatch.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {

    private final EmpRepository empRepository;

    private Long addEmpNum(Long empNum) {
        return empNum + 5;
    }

    @Override
    public void updateEmpNum(Long empId, Long empNum) {
        empRepository.update(empId,addEmpNum(empNum));
    }
}
