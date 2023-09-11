package com.example.demo.controller;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeContr {
    private EmployeeDAO _employeeDAO;

    @Autowired
    public EmployeeContr(EmployeeDAO employeeDAO){
        _employeeDAO = employeeDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("employees", _employeeDAO.index());
        return "employee/indexb";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        // Вывод определенного пользователя
        model.addAttribute("employee", _employeeDAO.show(id));
        return "employee/showb";
    }


    @GetMapping("/new")
    public String newEmployee(@ModelAttribute("employee") EmployeeModel employeeModel){
        // model.addAttribute("person", new EmployeeModel());
        return "employee/newb";
    }

    @PostMapping()
    public String create(@ModelAttribute("employee") EmployeeModel employeeModel){
        _employeeDAO.save(employeeModel);
        return "redirect:/employee";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("employee",_employeeDAO.show(id));
        return "employee/editb";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("employee") EmployeeModel employeeModel, @PathVariable("id") int id){
        _employeeDAO.update(id,employeeModel);
        return "redirect:/employee";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        _employeeDAO.delete(id);
        return "redirect:/employee";
    }
}
