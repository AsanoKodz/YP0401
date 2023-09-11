package com.example.demo.controller;


import com.example.demo.dao.CharterDAO;
import com.example.demo.model.CharterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/charter")
public class CharterContr {
    private CharterDAO _charterDAO;

    @Autowired
    public CharterContr(CharterDAO charterDAO){
        _charterDAO = charterDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("charters", _charterDAO.index());
        return "charter/indexb";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        // Вывод определенного пользователя
        model.addAttribute("charter", _charterDAO.show(id));
        return "charter/showb";
    }


    @GetMapping("/new")
    public String newCharter(@ModelAttribute("charter") CharterModel charterModel){
        return "charter/newb";
    }

    @PostMapping()
    public String create(@ModelAttribute("charter") CharterModel charterModel){
        _charterDAO.save(charterModel);
        return "redirect:/charter";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("charter",_charterDAO.show(id));
        return "charter/editb";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("charter") CharterModel charterModel, @PathVariable("id") int id){
        _charterDAO.update(id,charterModel);
        return "redirect:/charter";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        _charterDAO.delete(id);
        return "redirect:/charter";
    }
}
