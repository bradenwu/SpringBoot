package cn.edu.ncut.cs.springboot.springbootdatabase.dao.impl;

import cn.edu.ncut.cs.springboot.springbootdatabase.dao.StudentDao;
import cn.edu.ncut.cs.springboot.springbootdatabase.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Map<String, Object>> listStudent() {
        return jdbcTemplate.queryForList("select * from student");
    }

    @Override
    public int addStudent(Student student) {
        String sql = "insert into student (username, password, birthday, sex, address) values (?,?,?,?,?)";
        int row = jdbcTemplate.update(sql, student.getUsername(), student.getPassword(), student.getBirthday(),
                student.getSex(), student.getAddress());
        return row;
    }

    @Override
    public int deleteStudent(Long id) {
        String sql = "delete from student where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "update student set username = ?,password = ?, address = ? where id = ?";
        int row = jdbcTemplate.update(sql, student.getUsername(), student.getPassword(), student.getAddress(), student.getId());
        return row;
    }
    @Override
    public Student getStudentById(Long id) {
        String sql = "select * from student where id = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(Long.valueOf(resultSet.getInt(1)));
                student.setUsername(resultSet.getString(2));
                student.setPassword(resultSet.getString(3));
                student.setBirthday(resultSet.getDate(4));
                student.setSex(resultSet.getString(5));
                return student;
            }
        }, id);
    }
}
