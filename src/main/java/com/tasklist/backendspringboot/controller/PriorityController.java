package com.tasklist.backendspringboot.controller;

import org.springframework.web.bind.annotation.*;
import com.tasklist.backendspringboot.entity.Priority;
import com.tasklist.backendspringboot.repo.PriorityRepository;

import java.util.List;

// используем @RestController вместо обычного @Controller, чтобы все ответы сразу оборачивались в JSON
// иначе пришлось бы выполнять лишнюю работу, использовать @ResponseBody для ответа, указывать тип отправки JSON
@RestController
@RequestMapping ("/priority") // базовый адрес
public class PriorityController {

    // доступ к данным из БД
    private PriorityRepository priorityRepository;

    // автоматическое внедрение экземпляра класса через конструктор
    // не используем @Autowired ля переменной класса, т.к. "Field injection is not recommended "
    public PriorityController(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    // для тестирования адрес: http://localhost:8080/priority/test
    @GetMapping("/test")
    public List<Priority> test() {

        List<Priority> list = priorityRepository.findAll();

        return list; // JSON формат будет использоваться автоматически
    }

    @PostMapping("/add")
    public Priority add(@RequestBody Priority priority){
        return priorityRepository.save(priority);
    }

}
