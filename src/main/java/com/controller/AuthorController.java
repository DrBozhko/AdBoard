package com.controller;

import com.domain.Author;
import com.service.CrudService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("authors")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AuthorController {
    CrudService<Author> service;

    @PostMapping("/author")
    public void save(@RequestBody @Valid Author author) {
        service.save(author);
    }

    @PutMapping("/author")
    public void update(@RequestBody @Valid Author author) {
        service.update(author);
    }

    @GetMapping("/author/{id}")
    public Author find(@PathVariable int id) {
        return service.findById(id);
    }

    @DeleteMapping("/author/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }
}
