package com.szablewski.book.book;

import com.szablewski.book.common.PageResponse;
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

    @GetMapping
    ResponseEntity<PageResponse<BookResponse>> findAllBooks(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
                                                            Authentication connectedUser) {
        return ResponseEntity.ok(service.findAllBooks(page, size, connectedUser));
    }

    @GetMapping("/owner")
    ResponseEntity<PageResponse<BookResponse>> findAllBooksByOwner(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                                   @RequestParam(name = "size", defaultValue = "10", required = false) int size,
                                                                   Authentication connectedUser) {
        return ResponseEntity.ok(service.findAllBooksByOwner(page, size, connectedUser));
    }

    @GetMapping("/borrowed")
    ResponseEntity<PageResponse<BorrowedBookResponse>> findAllBorrowedBooks(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                                            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
                                                                            Authentication connectedUser) {
        return ResponseEntity.ok(service.findAllBorrowedBooks(page, size, connectedUser));
    }

    @GetMapping("/returned")
    ResponseEntity<PageResponse<BorrowedBookResponse>> findAllReturnedBooks(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                                            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
                                                                            Authentication connectedUser) {
        return ResponseEntity.ok(service.findAllReturnedBooks(page, size, connectedUser));
    }

    @PatchMapping("/shareable/{book-id}")
    ResponseEntity<Integer> updateShareableStatus(@PathVariable(name = "book-id") Integer bookId, Authentication connectedUser) {
        return ResponseEntity.ok(service.updateShareableStatus(bookId, connectedUser));
    }

    @PatchMapping("/archived/{book-id}")
    ResponseEntity<Integer> updateArchivedStatus(@PathVariable(name = "book-id") Integer bookId, Authentication connectedUser) {
        return ResponseEntity.ok(service.updateArchivedStatus(bookId, connectedUser));
    }

    @PostMapping("/borrow/{book-id}")
    ResponseEntity<Integer> borrowBook(@PathVariable(name = "book-id") Integer bookId, Authentication connectedUser) {
        return ResponseEntity.ok(service.borrowBook(bookId, connectedUser));
    }

    @PatchMapping("/borrow/return/{book-id}")
    ResponseEntity<Integer> returnBorrowedBook(@PathVariable(name = "book-id") Integer bookId, Authentication connectedUser) {
        return ResponseEntity.ok(service.returnBorrowedBook(bookId, connectedUser));
    }

    @PatchMapping("/borrow/return/approve/{book-id}")
    ResponseEntity<Integer> approveReturnBorrowedBook(@PathVariable(name = "book-id") Integer bookId, Authentication connectedUser) {
        return ResponseEntity.ok(service.approveReturnBorrowedBook(bookId, connectedUser));
    }


}
