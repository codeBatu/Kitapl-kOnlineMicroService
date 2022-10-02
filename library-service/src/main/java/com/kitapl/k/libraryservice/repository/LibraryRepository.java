package com.kitapl.k.libraryservice.repository;

import com.kitapl.k.libraryservice.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,String> {
}
