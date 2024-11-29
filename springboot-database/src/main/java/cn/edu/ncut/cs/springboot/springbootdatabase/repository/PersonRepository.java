package cn.edu.ncut.cs.springboot.springbootdatabase.repository;

import cn.edu.ncut.cs.springboot.springbootdatabase.entity.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByEmail(String email);

    List<Person> findByAgeBetween(Integer min, Integer max);
    List<Person> findByAgeBetween(Integer min, Integer max, Pageable pageable);

    //通过jqpl查询
    @Query("select p from Person p where email = :email")
    List<Person> findByEmail2(@Param("email")String email);

    //通过原生mysql查询
    @Query(value="select * from person where email = :email", nativeQuery=true)
    List<Person> findByEmail3(@Param("email")String email);

    List<Person> findByNameStartingWith(String name);
}
