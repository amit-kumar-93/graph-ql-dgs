package com.amit.model;

import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
public class Book {
    private String id;
    private String name;
    private int pageCount;
    private String authorId;

    final private static Book noBook= Book.builder().id("No ID").name("No Book Name").pageCount(0).authorId("No Author ID attached").build();

    private static List<Book> books = Arrays.asList(
        Book.builder().id("1").name("Java 8").pageCount(300).authorId("author 1").build(),
        Book.builder().id("2").name("Subtle Art of not giving a f*ck").pageCount(332).authorId("author 2").build(),
        Book.builder().id("3").name("Yeah!! this book makes you Millions").pageCount(123).authorId("author 2").build(),
        Book.builder().id("4").name("All that matters").pageCount(340).authorId("author 4").build()
    );


    public static Book getById(final String id){
        return books.stream().filter(book -> book.id.equals(id)).findFirst().orElse(noBook);
    }
}
