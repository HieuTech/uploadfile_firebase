package ra.springmvc_annotation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.springmvc_annotation.model.Student;

import java.lang.reflect.Method;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String Home( Model model){
        Student s1 = new Student(1,"hieu java",123);
        model.addAttribute("student",s1);
        return "home";
    }

    @PostMapping(value= "/handle-add")
    public String doAdd(@RequestParam("name") String name, @RequestParam("phone") String phone, Model model){
        model.addAttribute("name",name);
        model.addAttribute("phone",phone);
        return "profile";
    }
    @GetMapping("/form")
    public String form(){
        return "form";
    }


}
