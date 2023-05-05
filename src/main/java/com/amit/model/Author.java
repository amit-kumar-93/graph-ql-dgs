package com.amit.model;

import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
public class Author {
    private String id;
    private String firstName;
    private String lastName;

    final private static Author noAuthor= Author.builder().id("No ID").firstName("No FN").lastName("No LN").build();

    private static List<Author> books = Arrays.asList(
            Author.builder().id("Author 1").firstName("Amit").lastName("Kumar").build(),
            Author.builder().id("Author 2").firstName("Tima").lastName("Ramuk").build(),
            Author.builder().id("Author 3").firstName("Pehlaa").lastName("Akheerla").build(),
            Author.builder().id("Author 4").firstName("Bond").lastName("James Bond").build()
    );


    public static Author getById(final String id){
        return books.stream().filter(book -> book.id.equals(id)).findFirst().orElse(noAuthor);
    }
}
