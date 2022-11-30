package com.example.book_20221129.entity;

import com.example.book_20221129.dto.BookDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
//테이블명 지정하는 방법
@Table(name = "book_table")

//  DB에서 테이블과 같음 => XxxEntity = DB table
public class BookEntity {
//    Id: pk지정, GeneratedValue: auto_increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    column = 컬럼, length = 크기, nullable(null이여도 되냐?) = false = not null / default nullable=true
    @Column(length = 50, nullable = false)
    private String bookAuthor;

    @Column(length = 100, unique = true)
    private String bookName;

    @Column
    private int bookPrice;

//    @Column
//    private int bookCount;

//    BookDTO => BookEntity 변환 메서드
//    static으로 선언하여 class를 직접적으로 접근할 수 있음 => service Class에서 해당 메서드 활용
    public static BookEntity toSaveEntity(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName(bookDTO.getBookName());
        bookEntity.setBookAuthor(bookDTO.getBookAuthor());
        bookEntity.setBookPrice(bookDTO.getBookPrice());
        return bookEntity;
    }

}
