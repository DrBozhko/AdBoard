package com.controller;

import com.domain.Advertisement;
import com.domain.Author;
import com.service.AdvertisementService;
import com.service.CrudService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("advertisements")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AdvertisementController {
    AdvertisementService service;

    @PostMapping("/advertisement")
    public void save(@RequestBody @Valid Advertisement advertisement) {
        service.save(advertisement);
    }

    @PutMapping("/advertisement")
    public void update(@RequestBody @Valid Advertisement advertisement) {
        service.update(advertisement);
    }

    @GetMapping("/advertisement/{id}")
    public Advertisement find(@PathVariable int id) {
        return service.findById(id);
    }

    @DeleteMapping("/advertisement/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }

    @GetMapping("/advertisement/rubrics/{ids}")
    public List<Advertisement> findByRubrics(@PathVariable List<Integer> ids) {
        return service.findFromDifferentRubrics(ids);
    }

    @GetMapping("/advertisement/author/{id}")
    public List<Advertisement> findByAuthor(@PathVariable int id) {
        return service.findByAuthorId(id);
    }

    @GetMapping("/advertisement/date/{date}")
    public List<Advertisement> findByDate(@PathVariable String date) {
        return service.findByDate(LocalDate.parse(date));
    }

    @GetMapping("/advertisement/word/{word}")
    public List<Advertisement> findByWord(@PathVariable String word) {
        return service.findByText(word);
    }
}
