package com.example.book_20221129.repository;

import com.example.book_20221129.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//  extends: 상속 받을 때 선언
//  아래 코드는 공식처럼 생각하고 외울 것
//  <사용할 Entity(Class이름) 이름, pk(대부분 Long) 타입>
//  -> int, boolean 같은 타입은 사용불가, class 타입만 사용가능
//  -> XxxEntity 또는 Long 매개변수만 사용이 가능하다는 뜻

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
