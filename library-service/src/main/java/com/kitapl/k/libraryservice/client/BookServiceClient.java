package com.kitapl.k.libraryservice.client;

import com.kitapl.k.libraryservice.dto.BookDto;
import com.kitapl.k.libraryservice.dto.BookIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@FeignClient(name = "book-service",path = "/v1/books")

public interface BookServiceClient {

    @GetMapping("/isbn/{isbn}")
     ResponseEntity<BookIdDto> getBookByIsbn (@PathVariable @NotEmpty String isbn);
    @GetMapping("/book/{id}")
     ResponseEntity<BookDto> getBookById (@PathVariable @NotEmpty String id);
}
