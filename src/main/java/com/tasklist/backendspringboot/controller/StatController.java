package com.tasklist.backendspringboot.controller;

import com.tasklist.backendspringboot.service.StatService;
import com.tasklist.backendspringboot.util.MyLogger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tasklist.backendspringboot.entity.Stat;

@RestController
public class StatController {

    private final StatService statService; // сервис для доступа к данным (напрямую к репозиториям не обращаемся)

    // автоматическое внедрение экземпляра класса через конструктор
    // не используем @Autowired ля переменной класса, т.к. "Field injection is not recommended "
    public StatController(StatService statService) {
        this.statService = statService;
    }

    private final Long defaultId = 1l; // l - чтобы тип числа был Long, иначе будет ошибка компиляции

    // для статистика всгда получаем только одну строку с id=1 (согласно таблице БД)
    @GetMapping("/stat")
    public ResponseEntity<Stat> findById() {

        MyLogger.showMethodName("StatController: findById() ---------------------------------------------------------- ");

        // можно не использовать ResponseEntity, а просто вернуть коллекцию, код все равно будет 200 ОК
        return  ResponseEntity.ok(statService.findById(defaultId));
    }

}

