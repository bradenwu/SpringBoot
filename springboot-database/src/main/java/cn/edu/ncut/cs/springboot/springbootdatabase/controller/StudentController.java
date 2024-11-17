package cn.edu.ncut.cs.springboot.springbootdatabase.controller;

import cn.edu.ncut.cs.springboot.springbootdatabase.entity.Student;
import cn.edu.ncut.cs.springboot.springbootdatabase.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/add")
    public int addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/list")
    public List listStudent()
    {
        return studentService.listStudent();
    }

    @DeleteMapping("/delete/{id}")
    public int deleteStudent(@PathVariable("id") Long id)
    {
        return studentService.deleteStudent(id);
    }

    @PutMapping("update")
    public int updateStudent(@RequestBody Student student)
    {
        return studentService.updateStudent(student);
    }

    @GetMapping("/get/{id}")
    public Student GetStudentById(@PathVariable("id") Long id)
    {
        return studentService.getStudentById(id);
    }

}