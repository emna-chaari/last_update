package com.digitalclick.finalproject.controller;

import com.digitalclick.finalproject.dto.CategoryDto;
import com.digitalclick.finalproject.model.Category;
import com.digitalclick.finalproject.model.User;
import com.digitalclick.finalproject.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/category")
@RestController
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated CategoryDto categoryDto) {
        categoryService.save(categoryDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/categories")
    public List<Category> fetchCategoryList()
    {
        return categoryService.fetchCategoryList();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable("id") Integer id) {
        CategoryDto category = categoryService.findById(id);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        CategoryDto categoryDto = Optional.ofNullable(categoryService.findById(id)).orElse(null);
        if (categoryDto == null) {
            return ResponseEntity.notFound().build();
        }
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }






    @GetMapping("/page-query")
    public ResponseEntity<Page<CategoryDto>> pageQuery(CategoryDto categoryDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<CategoryDto> categoryPage = categoryService.findByCondition(categoryDto, pageable);
        return ResponseEntity.ok(categoryPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated CategoryDto categoryDto, @PathVariable("id") Integer id) {
        categoryService.update(categoryDto, id);
        return ResponseEntity.ok().build();
    }
}