package com.controller;

import com.domain.MatchingAd;
import com.domain.Rubric;
import com.service.CrudService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("mads")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class MadController {
    CrudService<MatchingAd> service;

    @PostMapping("/mad")
    public void save(@RequestBody @Valid MatchingAd matchingAd) {
        service.save(matchingAd);
    }

    @PutMapping("/mad")
    public void update(@RequestBody @Valid MatchingAd matchingAd) {
        service.update(matchingAd);
    }

    @GetMapping("/mad/{id}")
    public MatchingAd find(@PathVariable int id) {
        return service.findById(id);
    }

    @DeleteMapping("/mad/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }
}
