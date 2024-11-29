package cn.edu.ncut.cs.springboot.springbootdatabase.repository;

import cn.edu.ncut.cs.springboot.springbootdatabase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// 定义UserDao接口，继承自JpaRepository
// JpaRepository<User,Integer>中的两个泛型参数：
// - User：表示这个DAO操作的实体类类型
// - Integer：表示实体类主键的类型
public interface UserRepository extends JpaRepository<User,Integer> {
}
