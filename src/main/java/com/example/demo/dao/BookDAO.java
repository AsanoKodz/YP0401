package com.example.demo.dao;

import com.example.demo.model.BookModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class BookDAO {
    private static int Book_COUNT;
    private List<BookModel> books;
    {
        books = new ArrayList<>();

        books.add(new BookModel(++Book_COUNT,"Верные враги", "Громыко О.", 566, 2012));
        books.add(new BookModel(++Book_COUNT, "Крысиные бега", "Смернов Д.", 600, 2007));
        books.add(new BookModel(++Book_COUNT,"Мыловарня", "Кисин А.", 712,1994));
    }

    public List<BookModel> index(){

        return books;
    }

    public BookModel show(int id){
        return books.stream().filter(bookModel ->  bookModel.getId() == id).findAny().orElse(null);
    }

    public void save(BookModel book){
        book.setId(++Book_COUNT);
        books.add(book);
    }

    public void update(int id, BookModel bookModel){
        BookModel updateBook = show(id);
        updateBook.setAuthor(bookModel.getAuthor());
        updateBook.setNumberofpages(bookModel.getNumberofpages());
        updateBook.setYear(bookModel.getYear());
        updateBook.setName(bookModel.getName());
    }


    public void delete(int id){ books.removeIf(p-> p.getId() == id);}
}
