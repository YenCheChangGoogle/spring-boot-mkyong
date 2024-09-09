package com.mkyong.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    //以價錢排序降冪 http://127.0.0.1:8080/books?sortBy=price&sortDirection=desc
    //以編號排序升冪 http://127.0.0.1:8080/books?sortBy=id&sortDirection=asc
    //以出版日排序升冪 http://127.0.0.1:8080/books?sortBy=publishDate&sortDirection=asc
    @GetMapping("/books")
    public List<Book> findAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection) {
        Page<Book> result = bookService.findAll(pageNo, pageSize, sortBy, sortDirection);
        return result.getContent();

    }

}

