package com.mkyong.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    //GET http://localhost:8080/books/1
    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable Long id) {
        return bookService.findById(id);
    }
    
    //測試方式1
    //使用 JavaScript 的 Fetch API測試
    //fetch("http://localhost:8080/books", {
    //    method: "POST",
    //    headers: {
    //        "Content-Type": "application/json"
    //    },
    //    body: JSON.stringify({
    //        title: "Book E",
    //        price: 49.99,
    //        publishDate: "2023-04-01"
    //    })
    //})
    //.then(response => response.json())
    //.then(data => console.log(data))
    //.catch(error => console.error('Error:', error));
    //
    //測試方式2
    //使用POSTMAN測試 POST
    //BODY內使用JSON傳出內容
    //{
    //    "title": "Book E",
    //    "price": 49.99,
    //    "publishDate": "2023-04-01"
    //}
    
    // create a book
    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookService.save(book);
    }

    //測試方式
    //使用POSTMAN測試 PUT
    //BODY內使用JSON傳出內容
    //{
    //    "id": "3"
    //    "title": "Book F",
    //    "price": 59.99,
    //    "publishDate": "2023-11-23"
    //}
    // update a book
    @PutMapping
    public Book update(@RequestBody Book book) {
        return bookService.save(book);
    }
    
    //DELETE http://localhost:8080/books/3
    // delete a book
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    //GET http://localhost:8080/books/find/title/Book%20D
    @GetMapping("/find/title/{title}")
    public List<Book> findByTitle(@PathVariable String title) {
        return bookService.findByTitle(title);
    }
    
    //GET http://localhost:8080/books/find/date-after/2023-11-23
    @GetMapping("/find/date-after/{date}")
    public List<Book> findByPublishedDateAfter(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return bookService.findByPublishedDateAfter(date);
    }

}

