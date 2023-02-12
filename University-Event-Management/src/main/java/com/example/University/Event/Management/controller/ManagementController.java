package com.example.University.Event.Management.controller;

import com.example.University.Event.Management.model.Event;
import com.example.University.Event.Management.model.Student;
import com.example.University.Event.Management.service.IService;
import com.example.University.Event.Management.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/UMS")
public class ManagementController {

    @Autowired
    private ManagementService iService;


    @PostMapping("/add-student")
    public String addStudent(@RequestBody Student student){
        iService.addStudent(student);
        return "Hey, your task addStudent has been completed !";
    }

    @GetMapping("/update-student-department/id/{id}/department/{department}")
    public String updateDepartment(@PathVariable int id,@PathVariable String department){
        iService.updateDepartment(id,department);
        return "Hey, your task updateDepartment has been completed !";
    }

    @DeleteMapping("/delete-student/id/{id}")
    public void deleteStudent(@PathVariable int id){
        iService.deleteStudent(id);
    }

    @GetMapping("/get-all-student")
    public List<Student> getAllStudent(){
        return iService.getAllStudent();
    }

    @GetMapping("/getStudent-by-id/id/{id}")
    public Student getById(@PathVariable int id){
        return iService.getById(id);
    }

    // for Event model

    @PostMapping("/add-event")
    public String addEvent(@RequestBody Event event){
        iService.addEvent(event);
        return "Hey, your task addEvent has been completed !";
    }

    @PutMapping("/update-event/eventId/{eventId}")
    public String updateEvent(@RequestBody Event event,@PathVariable int eventId){
        iService.updateEvent(eventId,event);
        return "Hey, your task updateEvent has been completed !";
    }

    @DeleteMapping("/delete-event/eventId/{eventId}")
    public String deleteEvent(@PathVariable int eventId){
        iService.deleteEvent(eventId);
        return "Hey, your task deleteEvent has been completed !";
    }

    @GetMapping("/get-all-event")
    public List<Event> getAllEvent(){
        return iService.getAllEvent();
    }



}
