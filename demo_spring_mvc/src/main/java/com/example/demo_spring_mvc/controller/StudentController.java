package com.example.demo_spring_mvc.controller;


import com.example.demo_spring_mvc.entity.Student;
import com.example.demo_spring_mvc.repository.IStudentRepository;
import com.example.demo_spring_mvc.service.IStudentService;
import com.example.demo_spring_mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @ModelAttribute("subjects")
    public List<String> getSubjects(){
        return List.of("JS","JAVA","SQL","PHP");
    }

    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public ModelAndView showList(Model model){
        ModelAndView modelAndView = new ModelAndView("student/list");
        modelAndView.addObject("studentList",studentService.findAll());
        return  modelAndView;
    }
    @GetMapping("/add")
    public String showFormAdd(Model model){
        model.addAttribute("student", new Student());
        return  "student/add";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute Student student,
                       RedirectAttributes redirectAttributes
                       ){
        studentService.add(student);
        redirectAttributes.addFlashAttribute("mess","Them moi thanh cong");
        return "redirect:/student";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam(name = "id") int id, ModelMap map){
        map.addAttribute("student",studentService.findById(id));
        return  "student/detail";
    }
    @GetMapping("/{id}/detail")
    public String detail2(@PathVariable(name = "id") int id, ModelMap map){
        map.addAttribute("student",studentService.findById(id));
        return  "student/detail";
    }
}
