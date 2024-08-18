package org.example.final_project.controllers;

import lombok.AllArgsConstructor;
import org.example.final_project.domain.Category;
import org.example.final_project.service.CrudService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "category")
@AllArgsConstructor
public class CategoryController {
    CrudService<Category> categoryService;

    @PostMapping(value = "/save")
    public void saveCategory(@RequestBody Category category) {
        categoryService.add(category);
    }

    @PutMapping(value = "/update")
    public void updateCategory(@RequestBody Category category) throws SQLException {
        categoryService.update(category);
    }

    @GetMapping(value = "/find/{id}")
    public Category findById(@PathVariable("id") int id) throws SQLException {
        return categoryService.findById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") int id) throws SQLException {
        categoryService.removeById(id);
    }
}

