package com.example.book_20221129.service;

import com.example.book_20221129.dto.BookDTO;
import com.example.book_20221129.entity.BookEntity;
import com.example.book_20221129.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public void save(BookDTO bookDTO) {
//        bookDTO => bookEntity 옮겨담기
//        BookEntity bookEntity = new BookEntity();
//        bookEntity.setBookName(bookDTO.getBookName());
//        bookEntity.setBookAuthor(bookDTO.getBookAuthor());
//        bookEntity.setBookPrice(bookDTO.getBookPrice());
        BookEntity bookEntity = BookEntity.toSaveEntity(bookDTO);
        bookRepository.save(bookEntity);
//        bookRepository.save(bookDTO);
    }

    public List<BookDTO> findAll() {
        List<BookEntity> bookEntityList = bookRepository.findAll();
//        List<BookEntity> => List<BookDTO> 변환
//        1. 담아갈 List 객체 선언
        List<BookDTO> bookDTOList = new ArrayList<>();
//        2. EntityList에 담긴 Entity 객체를 하나씩 꺼내서 DTO 객체로 변환
        for (BookEntity bookEntity: bookEntityList) {
            BookDTO bookDTO = BookDTO.toDTO(bookEntity);
//        3. DTO 변환한 객체를 DTO List에 추가
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }

    public BookDTO findById(Long id) {
//        Optional => nullPoint 를 방지하기 위한 문법
        Optional<BookEntity> optionalBookEntity = bookRepository.findById(id);
//        isPresent -> 값이 있으면 true / isEmpty -> 값이 없으면 true
        if (optionalBookEntity.isPresent()) {
            // optional로 감싸진 객체를 꺼낼 때 get()
            BookEntity bookEntity = optionalBookEntity.get();
            BookDTO bookDTO = BookDTO.toDTO(bookEntity);
            return bookDTO;
        } else {
            return null;
        }
    }
}
