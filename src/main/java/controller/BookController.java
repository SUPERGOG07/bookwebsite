package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @RequestMapping(value = "/getBooks",method = {RequestMethod.POST})
    public Result getBook(){
        if(bookService.selectAllBooks()!=null){
            List<Books> booksList = bookService.selectAllBooks();
            return ResultUtil.data(booksList,"success");
        }
        return ResultUtil.error("fail");
    }
}
