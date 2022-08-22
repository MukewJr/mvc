package peaksoft.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Course;
import peaksoft.service.CompanyService;
import peaksoft.service.CourseService;

import java.util.List;

@Controller

public class CourseController {
    private  final CourseService courseService;

    private final CompanyService companyService;

    @Autowired
    public CourseController(CourseService courseService, CompanyService companyService) {
        this.courseService = courseService;
        this.companyService = companyService;
    }

    @GetMapping("/getCourses")
    public  String getAllCourses(@RequestParam("companyId")Long id, Model model){
        model.addAttribute("companyName",companyService.getCompanyById(id).getCompanyName());
        List<Course> courses=companyService.getCompanyById(id).getCourses();
        model.addAttribute("courses", courses);
        model.addAttribute("companyName",companyService.getCompanyById(id));
        return "courses/courses";
    }

    @GetMapping("/addCourse")
    public String addCourse(Model model){
        model.addAttribute("course",new Course());
        return "courses/addCourse";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@RequestParam("companId")Long id,@ModelAttribute("course") Course course){
        companyService.getCompanyById(id).getCourses().add(course);
        course.setCompany(companyService.getCompanyById(id));
        courseService.addCourse(course);
        return "redirect/getCourses?companyId";

    }

    @GetMapping("/updateCourse")
    public String updateCourse(@RequestParam("courseId")long id, Model model){
        Course course=courseService.getCourseById(id);
        model.addAttribute("course",course);
        return "courses/updateCourse";
    }

    @PostMapping("/saveUpdateCourse")
    public String saveUpdateCourse(@RequestParam("companyId")Long id,@ModelAttribute Course course){
        course.setCompany(companyService.getCompanyById(id));
        courseService.updateCourse(course);
        return "redirect:/getCourses?companyId";
    }

    @RequestMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("courseId") long id){
        courseService.deleteCourse(courseService.getCourseById(id));
        return "redirect:/getCourses";
    }
}
