package com.merio.spring.book.controller;

import com.merio.spring.base.exception.ResourceNotFoundException;

import com.merio.spring.book.controller.entity.BookEntity;
import com.merio.spring.book.controller.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class bookApiController {
    private final BookService bookService;

    public bookApiController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String ok() {
        return "ok";
    }
    @GetMapping("/api/v1/book")
    public List<BookEntity> all() {
        return bookService.all();
    }
    @GetMapping("/api/v1/book/{id}")
    public BookEntity byId(@PathVariable Integer id) {
        return bookService.byId(id).orElseThrow(ResourceNotFoundException::new);
    }
    @PostMapping("/api/v1/book")
    public BookEntity create(@RequestBody BookEntity request) {
        return bookService.create(request.getTitle(), request.getDescription());
    }
    @PutMapping("/api/v1/book/{id}")
    public BookEntity edit(@PathVariable Integer id, @RequestBody BookEntity request) {
        return bookService.edit(request).orElseThrow(ResourceNotFoundException::new);
    }
    @DeleteMapping("/api/v1/book/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        return bookService.delete(id);
    }
    @PatchMapping("/api/v1/book/{id}")
    public BookEntity path(@PathVariable Integer id, @RequestBody Map<String, String> fields) {
        return bookService.editPart(id,fields).orElseThrow(ResourceNotFoundException::new);
    }
}
