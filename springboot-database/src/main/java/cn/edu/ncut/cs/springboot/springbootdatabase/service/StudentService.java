package cn.edu.ncut.cs.springboot.springbootdatabase.service;

import cn.edu.ncut.cs.springboot.springbootdatabase.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Map<String, Object>> listStudent();

    int addStudent(Student student);

    int deleteStudent(Long id);

    int updateStudent(Student student);

    Student getStudentById(Long id);
}