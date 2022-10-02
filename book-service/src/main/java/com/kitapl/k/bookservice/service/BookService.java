package com.kitapl.k.bookservice.service;

import com.kitapl.k.bookservice.dto.BookDto;
import com.kitapl.k.bookservice.dto.BookIdDto;
import com.kitapl.k.bookservice.exception.BookNotFoundException;
import com.kitapl.k.bookservice.model.Book;
import com.kitapl.k.bookservice.repository.BookRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private  final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;

    }

    @PostConstruct
    public  void Init(){
      if(  bookRepository.findAll().isEmpty()){
          Book book = new Book("Dünyanın Gözü",2000,"Rober Jordan" ,"xxxxx","12345");
          Book book2 = new Book("Yüzüklerin Efendisi",1960,"J.R.R Tolkien","yyyy" ,"23456");
          bookRepository.saveAll(Arrays.asList(book,book2));

      }

    }

    public List<BookDto> getAllBooks(){
     return  bookRepository.findAll().stream().map(BookDto::convert).toList();
    }

    @Deprecated
    @NotNull
    private Optional<Book> findByBookInIsbn(String isbn){
       var book = bookRepository.findAll().stream().filter(x->x.getIsbn()==isbn);
          return   book.findFirst();

    }
    public BookIdDto findByIsbn(String isbn){
        return  bookRepository.findBooksByIsbn(isbn)
                .map(book -> new BookIdDto(book.getBookId(),book.getIsbn()))
                .orElseThrow(()->new BookNotFoundException("Book could not found by isbn: "+isbn));
    }
    public  BookDto findByBookDetailsById(String id){
        return  bookRepository.findById(id)
                .map(BookDto ::convert)
                .orElseThrow(()->new BookNotFoundException("Book could not found by id :"+id));
    }

}
