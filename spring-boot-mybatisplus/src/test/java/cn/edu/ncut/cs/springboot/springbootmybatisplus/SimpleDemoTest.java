package cn.edu.ncut.cs.springboot.springbootmybatisplus;

import cn.edu.ncut.cs.springboot.springbootmybatisplus.entity.Student;
import cn.edu.ncut.cs.springboot.springbootmybatisplus.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SimpleDemoTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testSelect() {
        List<Student> studentList = studentMapper.selectList(null);
        for (Student student : studentList) {
            System.out.println(student.getUsername());
        }
    }
}
