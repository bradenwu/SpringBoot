package cn.edu.ncut.cs.springboot.redisdemo.service.impl;

import cn.edu.ncut.cs.springboot.redisdemo.entity.Book;
import cn.edu.ncut.cs.springboot.redisdemo.mapper.BookMapper;
import cn.edu.ncut.cs.springboot.redisdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    @Cacheable(cacheNames = {"single_book"},key = "#root.targetClass+'.'+#root.methodName+'.'+#p0",
            unless = "#result == null")
    public Book getBook(Long id){
        return bookMapper.selectBookById(id);
    }
}