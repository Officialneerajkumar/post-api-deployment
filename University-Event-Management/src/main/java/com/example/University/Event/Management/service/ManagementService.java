package com.example.University.Event.Management.service;

import com.example.University.Event.Management.model.Student;
import com.example.University.Event.Management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementService {

    @Autowired
    private StudentRepository studentRepository;
    public void addStudent(Student student){
        studentRepository.save(student);
    }

//    public void updateDepartment(int id,String department){
//        Student student = studentRepository.findById(id);
//    }

    public void deleteStudent(int id){
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getById(int id){
        return studentRepository.findById(id).get();
    }

}
