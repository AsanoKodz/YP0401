package com.example.demo.controller;


import com.example.demo.dao.GenshinDAO;
import com.example.demo.model.GenshinModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/genshin")
public class GenshinContr {
    private GenshinDAO _genshinDAO;

    @Autowired
    public GenshinContr(GenshinDAO genshinDAO){
        _genshinDAO = genshinDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("genshins", _genshinDAO.index());
        return "genshin/indexb";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        // Вывод определенного пользователя
        model.addAttribute("genshin", _genshinDAO.show(id));
        return "genshin/showb";
    }


    @GetMapping("/new")
    public String newGenshin(@ModelAttribute("genshin") GenshinModel genshinModel){
        // model.addAttribute("person", new EmployeeModel());
        return "genshin/newb";
    }

    @PostMapping()
    public String create(@ModelAttribute("genshin") GenshinModel genshinModel){
        _genshinDAO.save(genshinModel);
        return "redirect:/genshin";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("genshin",_genshinDAO.show(id));
        return "genshin/editb";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("genshin") GenshinModel genshinModel, @PathVariable("id") int id){
        _genshinDAO.update(id,genshinModel);
        return "redirect:/genshin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        _genshinDAO.delete(id);
        return "redirect:/genshin";
    }
}
