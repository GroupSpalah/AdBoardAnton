package org.example.final_project.controllers;

import lombok.AllArgsConstructor;
import org.example.final_project.domain.Advertisement;
import org.example.final_project.service.AdvertisementService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "ad")
@AllArgsConstructor
public class AdController {
    AdvertisementService service;

    @PostMapping(value = "/save")
    public void save(@RequestBody Advertisement ad) {
        service.add(ad);
    }

    @PutMapping(value = "/update")
    public void updateAd(@RequestBody Advertisement ad) throws SQLException {
        service.update(ad);
    }

    @GetMapping(value = "/find/{id}")
    public Advertisement findById(@PathVariable("id") int id) throws SQLException {
        return service.findById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") int id) throws SQLException {
        service.removeById(id);
    }

    @GetMapping(value = "/findByCategory/{name}")
    public List<Advertisement> findByCategory(@PathVariable("name") String name) throws SQLException {
        return service.getByCategory(name);
    }

    @GetMapping(value = "/findByAuthor/{name}")
    public List<Advertisement> findByAuthor(@PathVariable("name") String name) throws SQLException {
        return service.showByAuthor(name);
    }

    @GetMapping(value = "/findByWord/{keyWord}")
    public List<Advertisement> findByWord(@PathVariable("keyWord") String keyWord) throws SQLException {
        return service.showByKeyWord(keyWord);
    }

    @GetMapping(value = "/findByDate/{date}")
    public List<Advertisement> findByDate(@PathVariable("date") LocalDate date) throws SQLException {
        return service.showByDate(date);
    }
}
