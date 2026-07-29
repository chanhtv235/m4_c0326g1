package com.example.demo_spring_data_jpa.controller;


import com.example.demo_spring_data_jpa.entity.Student;
import com.example.demo_spring_data_jpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    @Autowired
    private IStudentService studentService;

//    @GetMapping("")
//    public String showList(@PageableDefault(size = 2,
//                                       sort = {"name","id"},
//                                       direction = Sort.Direction.ASC) Pageable pageable,
//                           Model model) {
//        Page<Student> studentPage = studentService.findAll(pageable);
//        model.addAttribute("studentPage", studentPage);
//        return "student/list";
//    }

    @GetMapping("")
    public String showList(@RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "2") int size,
                           @RequestParam(name = "searchName",defaultValue = "") String searchName,
                           Model model) {
        Sort sort = Sort.by("name").descending().and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(page,size, sort);
        Page<Student> studentPage = studentService.search1(searchName,pageable);
        model.addAttribute("studentPage", studentPage);
        model.addAttribute("searchName", searchName);
        return "student/list";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("student", new Student());
        return "student/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Student student,
                       RedirectAttributes redirectAttributes
    ) {
        studentService.add(student);
        redirectAttributes.addFlashAttribute("mess", "Them moi thanh cong");
        return "redirect:/student";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam(name = "id") int id, ModelMap map) {
        map.addAttribute("student", studentService.findById(id));
        return "student/detail";
    }

    @GetMapping("/{id}/detail")
    public String detail2(@PathVariable(name = "id") int id, ModelMap map) {
        map.addAttribute("student", studentService.findById(id));
        return "student/detail";
    }
}
