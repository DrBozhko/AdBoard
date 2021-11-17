package com.controller;

import com.domain.Rubric;
import com.service.CrudService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("rubrics")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class RubricController {
    CrudService<Rubric> service;

    @PostMapping("/rubric")
    public void save(@RequestBody @Valid Rubric rubric) {
        service.save(rubric);
    }

    @PutMapping("/rubric")
    public void update(@RequestBody @Valid Rubric rubric) {
        service.update(rubric);
    }

    @GetMapping("/rubric/{id}")
    public Rubric find(@PathVariable int id) {
        return service.findById(id);
    }

    @DeleteMapping("/rubric/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }
}
