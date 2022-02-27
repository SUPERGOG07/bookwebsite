package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pojo.Books;
import service.BookService;
import util.Result;
import util.ResultUtil;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    BookService bookService;

    //get books
    @RequestMapping(value = "/books",method = {RequestMethod.GET})
    public Result getBook(){
        if(bookService.selectAllBooks()!=null){
            List<Books> booksList = bookService.selectAllBooks();
            return ResultUtil.data(booksList,"success");
        }
        return ResultUtil.error("fail");
    }

    //get books by sort
    @RequestMapping(value = "/books/sort/{sort}",method = {RequestMethod.POST})
    public Result getBookBySort(@PathVariable String sort){
        if(bookService.selectBookBySort(sort)!=null){
            List<Books> booksList = bookService.selectBookBySort(sort);
            return ResultUtil.data(booksList,"success");
        }
        return ResultUtil.error("fail");
    }

    //get books by limit
        @RequestMapping(value = "/books/limit/{index}",method = {RequestMethod.POST})
    public Result getBookByLimit(@PathVariable int index){
        int pageSize=4;
        if(bookService.selectBookByLimit(index,pageSize)!=null){
            List<Books> booksList = bookService.selectBookByLimit(index,pageSize);
            return ResultUtil.data(booksList,"success");
        }
        return ResultUtil.error("fail");
    }


}
