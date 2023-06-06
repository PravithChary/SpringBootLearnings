package com.api.book.bootrestbook.controllers;

import com.api.book.bootrestbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.book.bootrestbook.entities.Book;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
//    public List<Book> getBooks(){
//        return this.bookService.getAllBooks();
//    }
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> list = this.bookService.getAllBooks();
        if(list.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
//        return ResponseEntity.of(Optional.of(list));
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping("/books/{id}")
//    public Book getBook(@PathVariable("id") int id){
//        return this.bookService.getBookById(id);
//    }
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){
        Book book = this.bookService.getBookById(id);
        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/books")
//    public Book addBook(@RequestBody Book book){
//        Book b = this.bookService.addBook(book);
//        return b;
//    }
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book b = null;
        try{
            b = this.bookService.addBook(book);
            System.out.println(book);
            return ResponseEntity.of(Optional.of(b));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/books/{id}")
//    public void deleteBook(@PathVariable("id") int id){
//        this.bookService.deleteBook(id);
//    }
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
        try{
            this.bookService.deleteBook(id);
            // return ResponseEntity.ok().build();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/books/{id}")
//    public Book updateBook(@RequestBody Book book ,@PathVariable("id") int id){
//        this.bookService.updateBook(book, id);
//        return book;
//    }
    public ResponseEntity<Book> updateBook(@RequestBody Book book ,@PathVariable("id") int id){
        try{
            this.bookService.updateBook(book, id);
            return ResponseEntity.ok().body(book);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
