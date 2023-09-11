package com.example.demo.controller;

import com.example.demo.dao.DogDAO;
import com.example.demo.model.DogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dog")
public class DogContr {
    private DogDAO _dogDAO;

    @Autowired
    public DogContr(DogDAO dogDAO){
        _dogDAO = dogDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("dogs", _dogDAO.index());
        return "dog/indexb";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        // Вывод определенного пользователя
        model.addAttribute("dog", _dogDAO.show(id));
        return "dog/showb";
    }


    @GetMapping("/new")
    public String newDog(@ModelAttribute("dog") DogModel dogModel){
        // model.addAttribute("person", new DogModel());
        return "dog/newb";
    }

    @PostMapping()
    public String create(@ModelAttribute("dog") DogModel dogModel){
        _dogDAO.save(dogModel);
        return "redirect:/dog";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("dog",_dogDAO.show(id));
        return "dog/editb";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("dog") DogModel dogModel, @PathVariable("id") int id){
        _dogDAO.update(id,dogModel);
        return "redirect:/dog";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        _dogDAO.delete(id);
        return "redirect:/dog";
    }
}
