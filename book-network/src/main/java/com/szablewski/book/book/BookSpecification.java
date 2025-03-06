package com.szablewski.book.book;

import org.springframework.data.jpa.domain.Specification;

class BookSpecification {

    public static Specification<Book> withOwner(Integer ownerId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("owner").get("id"), ownerId);
    }
}
