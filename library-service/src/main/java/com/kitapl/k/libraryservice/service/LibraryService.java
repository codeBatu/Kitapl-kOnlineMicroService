package com.kitapl.k.libraryservice.service;

import com.kitapl.k.libraryservice.client.BookServiceClient;
import com.kitapl.k.libraryservice.dto.AddBookRequest;
import com.kitapl.k.libraryservice.dto.LibraryDto;
import com.kitapl.k.libraryservice.exception.LibraryNotFoundError;
import com.kitapl.k.libraryservice.model.Library;
import com.kitapl.k.libraryservice.repository.LibraryRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    private  final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;
    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }

    public LibraryDto getAllBooksInLibraryById(String id){
        Library lib = libraryRepository.findById(id)
                .orElseThrow(()-> new LibraryNotFoundError("Library not Found  by Id :" + id));

     return new LibraryDto(lib.getId(),lib.getUserBook().stream()
             .map(bookServiceClient::getBookById)
             .map(ResponseEntity::getBody)
             .toList()
     );

    }

    public LibraryDto createLibrary(){
        Library lib = libraryRepository.save(new Library());
        return  new LibraryDto(lib.getId());
    }
        public void addBookToLibrary(AddBookRequest addBookRequest){

        var  bookId = bookServiceClient.getBookByIsbn(addBookRequest.getIsbn()).getBody();
        Library lib = libraryRepository.findById(addBookRequest.getBookId())
                .orElseThrow(()-> new LibraryNotFoundError("Library not Found  by Id :" + addBookRequest.getIsbn()));
        lib.getUserBook().add(bookId.getBookId());
        libraryRepository.save(lib);
        }


}
