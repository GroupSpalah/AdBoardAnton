package org.example.final_project.controllers;

import lombok.AllArgsConstructor;
import org.example.final_project.domain.MatchingAd;
import org.example.final_project.service.CrudService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "matchAd")
@AllArgsConstructor
public class MatchAdController {
    CrudService<MatchingAd> matchAdService;

    @PostMapping(value = "/save")
    public void saveMatch(@RequestBody MatchingAd matchingAd) {
        matchAdService.add(matchingAd);
    }

    @PutMapping(value = "/update")
    public void updateMatch(@RequestBody MatchingAd matchingAd) throws SQLException {
        matchAdService.update(matchingAd);
    }

    @GetMapping(value = "/find/{id}")
    public MatchingAd findById(@PathVariable("id") int id) throws SQLException {
        return matchAdService.findById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") int id) throws SQLException {
        matchAdService.removeById(id);
    }
}

