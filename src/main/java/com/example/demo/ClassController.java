package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;


    @PostMapping("/create")
    public String addCar(@RequestParam String title) {
        Class klass = new Class();
        klass.setTitle(title);

        if (classService.addClass(klass)) {
            return ("Class " + klass + " added");
        }
        return (klass + " Already exist");
    }


    @GetMapping
    public List<Class> allClasses(){
        return classService.findAll();
    }


    @GetMapping("/{id}")
    public Class findClassById (@PathVariable("id") Long Id) {
        return classService.findClassById(Id);
    }

}
