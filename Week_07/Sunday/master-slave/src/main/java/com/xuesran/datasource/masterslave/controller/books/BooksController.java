package com.xuesran.datasource.masterslave.controller.books;

import com.xuesran.datasource.masterslave.entity.Books;
import com.xuesran.datasource.masterslave.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Books controller.
 */
@RestController
public class BooksController {
    private BooksService booksService;

    /**
     * Instantiates a new Books controller.
     *
     * @param booksService the books service
     */
    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    /**
     * Add book.
     *
     * @param book the book
     */
    @PostMapping(value = "/books/add", consumes = {"application/json"})
    public void addBook(@RequestBody Books book) {
        booksService.addBook(book);
    }

    /**
     * Gets all books from master.
     *
     * @return the all books from master
     */
    @GetMapping(value = "/books/find/master")
    public List getAllBooksFromMaster() {
        return booksService.getAllBooksFromMaster();
    }

    /**
     * Gets all books from slave.
     *
     * @return the all books from slave
     */
    @GetMapping(value = "/books/find/slave")
    public List getAllBooksFromSlave() {
        return booksService.getAllBooksFromSlave();
    }
}
