package com.tasklist.backendspringboot.controller;

import com.tasklist.backendspringboot.service.StatService;
import com.tasklist.backendspringboot.util.MyLogger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tasklist.backendspringboot.entity.Stat;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StatController {

    private final StatService statService;

    public StatController(StatService statService) {
        this.statService = statService;
    }

    @GetMapping("/stat")
    public ResponseEntity<Stat> findById() {

        MyLogger.showMethodName("StatController: findById() ---------------------------------------------------------- ");

        Long defaultId = 1L;
        return  ResponseEntity.ok(statService.findById(defaultId));
    }

}

