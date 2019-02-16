package com.lgh.spring.boot.pojo.library;

import com.lgh.spring.boot.mongo.model.library.MBook;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class AddBookRequest {
    @Valid
    @NotEmpty(message = "{validated.not-empty}")
    private List<MBook> books;

    public List<MBook> getBooks() {
        return books;
    }

    public void setBooks(List<MBook> books) {
        this.books = books;
    }
}
