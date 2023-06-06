package com.api.book.bootrestbook.services;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;
//    public static List<Book> list = new ArrayList<Book>();
//    static {
//        list.add(new Book(24,"Book1","Author1"));
//        list.add(new Book(25,"Book2","Author2"));
//        list.add(new Book(26,"Book3","Author3"));
//        list.add(new Book(27,"Book4","Author4"));
//    }

    // Getting all books
    public List<Book> getAllBooks(){
//        return list;
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // get single book by Id
    public Book getBookById(int id){
        Book book = null;
        try{
//            book = list.stream().filter(e->e.getId()==id).findFirst().get();
            book = this.bookRepository.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }

    // adding the book
    public Book addBook(Book book){
//        list.add(book);
        Book result = bookRepository.save(book);
        return result;
    }

    // deleting the book
    public void deleteBook(int id){
//        list = list.stream().filter(e -> e.getId()!=id).collect(Collectors.toList());
        bookRepository.deleteById(id);
    }

    // update the book
    public void updateBook(Book book, int id){
//        list = list.stream().map(e->{
//            if(e.getId()==id){
//                e.setTitle(book.getTitle());
//                e.setAuthor(book.getAuthor());
//            }
//            return e;
//        }).collect(Collectors.toList());
        book.setId(id);
        bookRepository.save(book);
    }

}
