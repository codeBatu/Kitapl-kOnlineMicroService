package com.kitapl.k.bookservice.api;

import com.kitapl.k.bookservice.dto.BookDto;
import com.kitapl.k.bookservice.dto.BookIdDto;
import com.kitapl.k.bookservice.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/v1/books")
@Validated
public class BookController {

    private  final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
@GetMapping
    public ResponseEntity<List<BookDto>> getAllBook(){

        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @GetMapping("/isbn/{isbn}")
    public  ResponseEntity<BookIdDto> getBookByIsbn (@PathVariable @NotEmpty String isbn){


return  ResponseEntity.ok(bookService.findByIsbn(isbn));
    }
    @GetMapping("/book/{id}")
    public  ResponseEntity<BookDto> getBookById (@PathVariable @NotEmpty String id){

        return ResponseEntity.ok(bookService.findByBookDetailsById(id));

    }






}
