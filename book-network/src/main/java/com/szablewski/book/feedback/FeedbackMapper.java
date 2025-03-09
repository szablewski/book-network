package com.szablewski.book.feedback;

import com.szablewski.book.book.Book;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
class FeedbackMapper {
    Feedback toFeedback(FeedbackRequest request) {
        return Feedback.builder()
                .note(request.note())
                .book(Book.builder()
                        .id(request.bookId())
                        .archived(false)
                        .shareable(false)
                        .build()
                )
                .comment(request.comments())
                .build();
    }

    FeedbackResponse toFeedbackResponse(Feedback feedback, Integer userId) {
        return FeedbackResponse.builder()
                .note(feedback.getNote())
                .comment(feedback.getComment())
                .ownFeedback(Objects.equals(feedback.getCreatedBy(), userId))
                .build();
    }
}
