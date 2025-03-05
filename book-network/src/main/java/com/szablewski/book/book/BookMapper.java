package com.szablewski.book.book;

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
                // todo implements this later
//                .cover()
                .build();
    }
}