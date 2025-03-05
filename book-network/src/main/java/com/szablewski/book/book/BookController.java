package com.szablewski.book.book;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
@Tag(name = "Book")
class BookController {

    private final BookService service;

    @PostMapping
    ResponseEntity<Integer> saveBook(@RequestBody @Valid BookRequest request, Authentication connectUser) {
        return ResponseEntity.ok(service.save(request, connectUser));
    }

    @GetMapping("{book-id}")
    ResponseEntity<BookResponse> findBookById(@PathVariable(name = "book-id") Integer bookId) {
        return ResponseEntity.ok(service.findById(bookId));
    }
}
