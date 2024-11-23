package cn.edu.ncut.cs.springboot.springbootdatabase.dao;

import cn.edu.ncut.cs.springboot.springbootdatabase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// 定义UserDao接口，继承自JpaRepository
// JpaRepository<User,Integer>中的两个泛型参数：
// - User：表示这个DAO操作的实体类类型
// - Integer：表示实体类主键的类型
public interface UserDao extends JpaRepository<User,Integer> {
    // 空接口体，但已经继承了JpaRepository的所有基础方法，包括：
    // save(T entity)：保存实体
    // findById(ID id)：根据ID查询
    // findAll()：查询所有
    // deleteById(ID id)：根据ID删除
    // count()：统计总数
    // 等等...
}
