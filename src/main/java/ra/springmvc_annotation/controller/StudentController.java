package ra.springmvc_annotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.springmvc_annotation.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/form-add")
    public String addStudent(){
        return "add-student";
    }
    @PostMapping("/add-student")
    public String doAdd(@ModelAttribute Student student, Model model){
        model.addAttribute("list",student.toString());

        return "list_student";
    }
}



