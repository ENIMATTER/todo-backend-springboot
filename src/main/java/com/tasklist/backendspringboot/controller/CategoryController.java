package com.tasklist.backendspringboot.controller;

import org.springframework.web.bind.annotation.*;
import com.tasklist.backendspringboot.entity.Category;
import com.tasklist.backendspringboot.repo.CategoryRepository;

import java.util.List;

// используем @RestController вместо обычного @Controller, чтобы все ответы сразу оборачивались в JSON
// иначе пришлось бы выполнять лишнюю работу, использовать @ResponseBody для ответа, указывать тип отправки JSON
@RestController
@RequestMapping ("/category") // базовый адрес
public class CategoryController {

    // доступ к данным из БД
    private CategoryRepository categoryRepository;

    // автоматическое внедрение экземпляра класса через конструктор
    // не используем @Autowired ля переменной класса, т.к. "Field injection is not recommended "
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    // для тестирования адрес: http://localhost:8080/category/test
    @GetMapping("/test")
    public List<Category> test() {

        List<Category> list = categoryRepository.findAll();

        return list; // JSON формат будет использоваться автоматически
        
    }

    @PostMapping("/add")
    public Category add(@RequestBody Category category){
        return categoryRepository.save(category);
    }

}
