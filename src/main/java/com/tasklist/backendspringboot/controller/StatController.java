package com.tasklist.backendspringboot.controller;

import com.tasklist.backendspringboot.util.MyLogger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tasklist.backendspringboot.entity.Stat;
import com.tasklist.backendspringboot.repo.StatRepository;

@RestController
public class StatController {

    private final StatRepository statRepository;

    public StatController(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    private final Long defaultId = 1l; // l - чтобы тип числа был Long, иначе будет ошибка компиляции

    // для статистика всгда получаем только одну строку с id=1 (согласно таблице БД)
    @GetMapping("/stat")
    public ResponseEntity<Stat> findById() {

        MyLogger.showMethodName("StatController: findById() ---------------------------------------------------------- ");

        return  ResponseEntity.ok(statRepository.findById(defaultId).get());
    }


}
