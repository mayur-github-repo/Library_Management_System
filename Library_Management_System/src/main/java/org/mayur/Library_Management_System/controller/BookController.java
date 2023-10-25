package org.mayur.Library_Management_System.controller;

import org.mayur.Library_Management_System.exception.TxnServiceException;
import org.mayur.Library_Management_System.models.Book;
import org.mayur.Library_Management_System.models.BookFilterType;
import org.mayur.Library_Management_System.models.OperationType;
import org.mayur.Library_Management_System.request.CreateBookRequest;
import org.mayur.Library_Management_System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public void create(@RequestBody CreateBookRequest createBookRequest) throws TxnServiceException {
        bookService.create(createBookRequest);
    }

    @GetMapping("/find")
    public List<Book> findBooks(@RequestParam("filter") BookFilterType bookFiltertype,
                                @RequestParam("value") String value,
                                @RequestParam("operation")OperationType operationType){
     return bookService.findBooks(bookFiltertype, value, operationType);
    }

}
