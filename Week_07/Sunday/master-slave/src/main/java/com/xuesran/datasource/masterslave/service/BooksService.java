package com.xuesran.datasource.masterslave.service;

import com.xuesran.datasource.masterslave.dao.BooksDAO;
import com.xuesran.datasource.masterslave.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Books service.
 *
 * @author xueshun
 */
@Service
public class BooksService {
    private BooksDAO booksDAO;

    /**
     * Instantiates a new Books service.
     *
     * @param booksDAO the books dao
     */
    @Autowired
    public BooksService(BooksDAO booksDAO) {
        this.booksDAO = booksDAO;
    }

    /**
     * Add book.
     *
     * @param book the book
     */
    public void addBook(Books book) {
        booksDAO.saveAndFlush(book);
    }

    /**
     * Gets all books from master.
     *
     * @return the all books from master
     */
    public List getAllBooksFromMaster() {
        return booksDAO.getAllBooksFromMaster();
    }

    /**
     * Gets all books from slave.
     *
     * @return the all books from slave
     */
    public List getAllBooksFromSlave() {
        return booksDAO.getAllBooksFromSlave();
    }
}
