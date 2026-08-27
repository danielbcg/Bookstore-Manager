package com.danielbony.bockstoremanager.repository;

import com.danielbony.bockstoremanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
