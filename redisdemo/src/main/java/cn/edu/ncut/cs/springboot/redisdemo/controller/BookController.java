package cn.edu.ncut.cs.springboot.redisdemo.controller;


import cn.edu.ncut.cs.springboot.redisdemo.bloomfilter.BookBloomFilter;
import cn.edu.ncut.cs.springboot.redisdemo.entity.Book;
import cn.edu.ncut.cs.springboot.redisdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookBloomFilter bookBloomFilter;

    @GetMapping("/get")
    public Book getBook(Long id){
        if(bookBloomFilter.bloomFilter.mightContain(id)){
            System.out.println("The book of id equals "+id+" exists in db");
            return bookService.getBook(id);
        }else{
            System.out.println("The book of id equals "+id+" does not exist in db");
            return null;
        }
    }

}