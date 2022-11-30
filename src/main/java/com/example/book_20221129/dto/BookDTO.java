package com.example.book_20221129.dto;

import com.example.book_20221129.entity.BookEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookDTO {
    private Long id;
    private String bookName;
    private String bookAuthor;
    private int bookPrice;

//    Entity => DTO 변환 메서드
    public static BookDTO toDTO(BookEntity bookEntity) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(bookEntity.getId());
        bookDTO.setBookName(bookEntity.getBookName());
        bookDTO.setBookAuthor(bookEntity.getBookAuthor());
        bookDTO.setBookPrice(bookEntity.getBookPrice());
        return bookDTO;
    }
}
