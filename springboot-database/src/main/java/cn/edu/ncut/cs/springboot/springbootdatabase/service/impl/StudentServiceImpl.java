package cn.edu.ncut.cs.springboot.springbootdatabase.service.impl;

import cn.edu.ncut.cs.springboot.springbootdatabase.dao.StudentDao;
import cn.edu.ncut.cs.springboot.springbootdatabase.entity.Student;
import cn.edu.ncut.cs.springboot.springbootdatabase.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Map<String, Object>> listStudent() {
        return studentDao.listStudent();
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.addStudent(student);
    }
    @Override
    public int deleteStudent(Long id) {
        return studentDao.deleteStudent(id);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDao.getStudentById(id);
    }
}