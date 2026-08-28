package com.danielbony.bockstoremanager.service;

import com.danielbony.bockstoremanager.dto.BookDTO;
import com.danielbony.bockstoremanager.dto.MessageResponseDTO;
import com.danielbony.bockstoremanager.entity.Book;
import com.danielbony.bockstoremanager.mapper.BookMapper;
import com.danielbony.bockstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BookService {

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    @PostMapping
    public MessageResponseDTO create(BookDTO bookDTO){
        Book bookToSave =

                // antes do bookMapper.toModel(bookDTO) era assim,
                // mas n puxava o dto, por causa do objeto autor

                //Book.builder()
                //.name(bookDTO.getName())
                //.pages(bookDTO.getPages())
                //.chapters(bookDTO.getChapters())
                //.author(bookDTO.getAuthor())
                //.build();

                bookMapper.toModel(bookDTO);

        //se n tiver o builder do bookToSave, n da pra salvar bookDTO
        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with id: "+ savedBook.getId())
                .build();
    }
}
