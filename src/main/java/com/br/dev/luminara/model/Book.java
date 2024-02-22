package com.br.dev.luminara.model;

import com.br.dev.luminara.dto.book.BookData;
import com.br.dev.luminara.dto.book.UpdateBookData;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;
    @Column(name = "launch_date")
    private String launchDate;
    private String price;

    public Book(BookData data) {
        this.title = data.title();
        this.author = data.author();
        this.launchDate = data.launchDate();
        this.price = data.price();
    }

    public void updateInformationBook(UpdateBookData data) {
        if ((data.price())!= null) {
            this.price = data.price();
        }
    }

}
