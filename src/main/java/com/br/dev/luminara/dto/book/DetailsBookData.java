package com.br.dev.luminara.dto.book;

import com.br.dev.luminara.model.Book;

public record DetailsBookData(Long id, String author, String launchDate, String price, String title) {

    public DetailsBookData(Book book) {
        this(book.getId(), book.getAuthor(), book.getLaunchDate(), book.getPrice(), book.getTitle());
    }

}
