package cn.edu.ncut.cs.springboot.redisdemo.mapper;

import cn.edu.ncut.cs.springboot.redisdemo.entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    /**
     * 根据ID获取book
     */
    Book selectBookById(Long id);
}
