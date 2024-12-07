package cn.edu.ncut.cs.springboot.redisdemo.service;

import cn.edu.ncut.cs.springboot.redisdemo.entity.Book;

public interface BookService {
    /**
     * 根据ID获取book
     */
    Book getBook(Long id);
}
