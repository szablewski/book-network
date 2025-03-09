package com.szablewski.book.feedback;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
class FeedbackResponse {

    private Double note;
    private String comment;
    private boolean ownFeedback;
}
