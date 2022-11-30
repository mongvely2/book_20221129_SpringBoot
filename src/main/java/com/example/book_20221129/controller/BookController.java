package com.example.book_20221129.controller;

import com.example.book_20221129.dto.BookDTO;
import com.example.book_20221129.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
//    @Autowired        필드 주입 방식 -> 권고하지 않음
//    private BookService bookService;

//    생성자 주입 방식 -> 권고 / 위에서 @RequiredArgsConstructor 선언 후 아래 코드 작성, private은 필수가 아니지만 final은 필수
//    final : 선언 후 값 변경 불가, (= javascript: const와 같은 기능)
//    @RequiredArgsConstructor : final을 선언해준 클래스만 생성자를 생성해줌 / ~ArgsConstructor: 생성자 만들어주는 어노테이션
    private final BookService bookService;

    @GetMapping("/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BookDTO bookDTO) {
        bookService.save(bookDTO);
        return "index";
    }

    @GetMapping("/books")
    public String findAll(Model model) {
        List<BookDTO> bookDTOList = bookService.findAll();
        model.addAttribute("bookList", bookDTOList);
        return "list";
    }

    @GetMapping("/book/{id}")
//    경로상에 있는 숫자를 전달해주는 어노테이션: @PathVariable -> 문자가 있으면 error
    public String findById(@PathVariable Long id, Model model) {
        System.out.println("id = " + id);
        BookDTO bookDTO = bookService.findById(id);
        model.addAttribute("book", bookDTO);
        return "detail";
    }
}


















