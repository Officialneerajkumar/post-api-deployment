package com.example.University.Event.Management.service;

import com.example.University.Event.Management.model.Event;
import com.example.University.Event.Management.model.Student;
import com.example.University.Event.Management.repository.EventRepository;
import com.example.University.Event.Management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EventRepository eventRepository;
    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateDepartment(int id,String department){
        Student newStudent = studentRepository.findById(id).get();
        newStudent.setDepartment(department);
        studentRepository.save(newStudent);
    }

    public void deleteStudent(int id){
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getById(int id){
        return studentRepository.findById(id).get();
    }

    // Event methods
    public void addEvent(Event event){
        eventRepository.save(event);
    }

    public void updateEvent(int eventId,Event event){
        Event eventOBJ = eventRepository.findById(eventId).get();
        eventOBJ.setEventId(event.getEventId());
        eventOBJ.setEventName(event.getEventName());
        eventOBJ.setLocationOfEvent(event.getLocationOfEvent());
        eventOBJ.setDate(event.getDate());
        eventOBJ.setStartTime(event.getStartTime());
        eventOBJ.setEndTime(event.getEndTime());
        eventRepository.save(eventOBJ);
    }

    public void deleteEvent(int evenetId){
        eventRepository.deleteById(evenetId);
    }

    public List<Event> getAllEvent(){
        return eventRepository.findAll();
    }


}
