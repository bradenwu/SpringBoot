package cn.edu.ncut.springboot.springbootdatabase;// ReSharper disable all CheckNamespace
// Please ensure all the tests are contained within the same namespace

import cn.edu.ncut.cs.springboot.springbootdatabase.repository.PersonRepository;
import cn.edu.ncut.cs.springboot.springbootdatabase.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootTest
public class JpaApplicationTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void contextLoads() {}

    @Test
    public void findByBetween() {
        List<Person> persons = personRepository.findByAgeBetween(10, 20);
        persons.forEach(System.out::println);
    }

    @Test
    public void findByBetweenWithPage() {
        List<Person> persons = personRepository.findByAgeBetween(10, 20, PageRequest.of(1, 3));
        persons.forEach(System.out::println);
    }
    @Test
    public void findByNameStartsWith() {
        List<Person> persons = personRepository.findByNameStartingWith("张");
        persons.forEach(System.out::println);
    }

}