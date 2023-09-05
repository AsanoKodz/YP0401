package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/")
public class HomeController {

    @GetMapping("/home")
    public String index(){
        return "home";
    }

    @GetMapping("/about")
    public String as(@RequestParam(name="a", required = false, defaultValue = "Привет") Double a, Model model){
        model.addAttribute("temt", a);
        System.out.println(a);
        return "Info";
    }
    @PostMapping("/about")
    public String ast(@RequestParam(required = false) Double a, Double b, String mod, Model model){
        double rec = 0;
        model.addAttribute("temp", a);
        model.addAttribute("tempt", b);
        if(a != null &&  b != null){
        if (mod.contains("a1")){
            rec=a*b;
        }
        if (mod.contains("a2")){
            rec=a-b;
        }
        if (mod.contains("a3")){
            if (b==0) {rec=0;}
            else {rec=a/b;}
        }
        if (mod.contains("a4")){
            rec=a+b;
        }}
        else {rec= 0;}
        model.addAttribute("temt", rec);
        System.out.println(rec);
        return "Info";
    }


    @GetMapping("/converter")
    public String asу(@RequestParam(name="a", required = false, defaultValue = "Привет") Double a, Model model){
        model.addAttribute("temtt", a);
        System.out.println(a);
        return "Currencies";
    }
    @PostMapping("/converter")
    public String astу(@RequestParam(required = false) Double a, Double b, String mod, Model model){
        double rec = 0;
        model.addAttribute("temp", a);
        if(a != null) {
            if (mod.contains("a1")) {
                rec = a * 1;
            }
            if (mod.contains("a2")) {
                rec = a*96.62;
            }
            if (mod.contains("a3")) {
                rec = a * 0.659927;
            }

            if (mod.contains("a4")) {
                rec = a * 1;
            }
            if (mod.contains("a5")){
                rec = a *0.01035;
            }
            if (mod.contains("a6")){
                rec = a *1.52;
            }
        }
        else {rec= 0;}
        model.addAttribute("temtt", rec);
        System.out.println(rec);
        return "Currencies";
    }
}
