package org.example.final_project.controllers;

import lombok.AllArgsConstructor;
import org.example.final_project.domain.Author;
import org.example.final_project.service.CrudService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "author")
@AllArgsConstructor
public class AuthorController {
    CrudService<Author> authorService;

    @PostMapping(value = "/save")
    public void saveAuthor(@RequestBody Author author) {
        authorService.add(author);
    }

    @PutMapping(value = "/update")
    public void updateAuthor(@RequestBody Author author) throws SQLException {
        authorService.update(author);
    }

    @GetMapping(value = "/find/{id}")
    public Author findById(@PathVariable("id") int id) throws SQLException {
        return authorService.findById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") int id) throws SQLException {
        authorService.removeById(id);
    }
}
