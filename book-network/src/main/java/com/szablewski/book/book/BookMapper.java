package com.szablewski.book.book;

import com.szablewski.book.file.FileUtils;
import com.szablewski.book.history.BookTransactionHistory;
import org.springframework.stereotype.Service;

@Service
class BookMapper {

    Book toBook(BookRequest request) {
        return Book.builder()
                .id(request.id())
                .title(request.title())
                .authorName(request.authorName())
                .synopsis(request.synopsis())
                .archived(false)
                .shareable(request.shareable())
                .build();
    }

    BookResponse toBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorName(book.getAuthorName())
                .isbn(book.getIsbn())
                .synopsis(book.getSynopsis())
                .rate(book.getRate())
                .shareable(book.isArchived())
                .archived(book.isArchived())
                .owner(book.getOwner().fullName())
                .cover(FileUtils.readFileFromLocation(book.getBookCover()))
                .build();
    }

    BorrowedBookResponse toBorrowedBooksResponse(BookTransactionHistory history) {

        return BorrowedBookResponse.builder()
                .id(history.getBook().getId())
                .title(history.getBook().getTitle())
                .authorName(history.getBook().getAuthorName())
                .isbn(history.getBook().getIsbn())
                .rate(history.getBook().getRate())
                .returned(history.isReturned())
                .returnedApproved(history.isReturnApproved())
                .build();
    }
}