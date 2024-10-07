package com.example.minibatch.config;

import com.example.minibatch.entity.Emp;
import com.example.minibatch.repository.EmpRepository;
import com.example.minibatch.service.EmpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Scheduler {

    private final EmpService empService;
    private final EmpRepository empRepository;

    @Scheduled(fixedRate =  60000)
    public void schedule(){
        log.info("스케줄러 시작");
        Emp emp = empRepository.findByEmpId(1L)
            .orElseThrow(() -> new RuntimeException("1 아이디가 존재하지 않습니다"));

        empService.updateEmpNum(emp.getEmpId(),emp.getEmpNum());

        log.info("스케줄러 끝");
    }



}
