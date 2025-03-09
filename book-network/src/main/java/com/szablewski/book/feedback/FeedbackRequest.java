package com.szablewski.book.feedback;

import jakarta.validation.constraints.*;

record FeedbackRequest(
        @Positive(message = "200")
        @Min(value = 0, message = "210")
        @Max(value = 5, message = "202")
        Double note,
        @NotNull(message = "203")
        @NotEmpty(message = "203")
        @NotBlank(message = "203")
        String comments,
        @NotNull(message = "204")
        Integer bookId
) {
}
