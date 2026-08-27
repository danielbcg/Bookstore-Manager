package com.danielbony.bockstoremanager.service;

import com.danielbony.bockstoremanager.dto.MessageResponseDTO;
import com.danielbony.bockstoremanager.entity.Book;
import com.danielbony.bockstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    @PostMapping
    public MessageResponseDTO create(Book book){
        Book savedBook = bookRepository.save(book);
        return MessageResponseDTO.builder()
                .message("Book created with id: "+ savedBook.getId())
                .build();
    }
}
