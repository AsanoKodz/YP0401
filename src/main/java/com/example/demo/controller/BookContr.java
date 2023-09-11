package com.example.demo.controller;

import com.example.demo.dao.BookDAO;
import com.example.demo.model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookContr {
    private BookDAO _bookDAO;

    @Autowired
    public BookContr(BookDAO bookDAO){
        _bookDAO = bookDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("books", _bookDAO.index());
        return "book/indexb";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        // Вывод определенного пользователя
        model.addAttribute("book", _bookDAO.show(id));
        return "book/showb";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("book") BookModel bookModel){
        // model.addAttribute("book", new BookModel());
        return "book/newb";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") BookModel bookModel){
        _bookDAO.save(bookModel);
        return "redirect:/book";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("book",_bookDAO.show(id));
        return "book/editb";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") BookModel bookModel, @PathVariable("id") int id){
        _bookDAO.update(id,bookModel);
        return "redirect:/book";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        _bookDAO.delete(id);
        return "redirect:/book";
    }
}
