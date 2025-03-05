package com.szablewski.book.book;

import com.szablewski.book.user.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    Integer save(BookRequest request, Authentication connectUser) {
        User user = (User) connectUser.getPrincipal();
        Book book = bookMapper.toBook(request);

        book.setOwner(user);

        log.info("Saving book: {}", book);
        return bookRepository.save(book).getId();
    }

    BookResponse findById(Integer bookId) {
        return bookRepository.findById(bookId)
                .map(bookMapper::toBookResponse)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with the ID:: " + bookId));
    }
}
