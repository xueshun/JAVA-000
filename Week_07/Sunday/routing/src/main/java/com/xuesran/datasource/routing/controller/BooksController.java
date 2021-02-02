package com.xuesran.datasource.routing.controller;

import com.xuesran.datasource.routing.entity.BooksEntity;
import com.xuesran.datasource.routing.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Books controller.
 *
 * @author xueshun
 */
@RestController
@RequestMapping(value = "/books")
public class BooksController {

    private IBooksService booksService;

    @Autowired
    public BooksController(IBooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping(value = "/add")
    public void add(){
        booksService.save(BooksEntity.builder()
                .price(1.1)
                .build());
    }

}
