package com.br.dev.luminara.dto.book;

import com.br.dev.luminara.model.Book;

public record BookListeningData(Long id, String author, String launchDate, String price, String title) {
    public BookListeningData(Book book) {
        this(book.getId(), book.getAuthor(), book.getLaunchDate(), book.getPrice(), book.getTitle());
    }
}
