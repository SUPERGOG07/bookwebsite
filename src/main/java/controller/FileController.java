package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pojo.Books;
import service.AdminService;
import service.BookService;
import util.FileUtil;
import util.Result;
import util.ResultUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class FileController {

    @Autowired
    @Qualifier("BookServiceImpl")
    BookService bookService;

    @Autowired
    @Qualifier("AdminServiceImpl")
    AdminService adminService;

    //upload
    @RequestMapping (value = "/upload",method = {RequestMethod.POST})

    public Result upload(HttpServletRequest request,
                         @RequestParam(value = "name",required = false)String name,
                         @RequestParam(value = "author",required = false)String author,
                         @RequestParam(value = "sort",required = false)String sort,
                         @RequestParam(value = "intro",required = false)String intro,
                         @RequestParam(value = "file",required = false) MultipartFile file) throws IOException {

        System.out.println(name+" "+author+" "+sort);
        System.out.println(intro);
        System.out.println(!file.isEmpty());
        if(!bookService.checkBook(name,author).isEmpty()){
            return ResultUtil.error("已存在同样书籍");
        }
        Books book = new Books(name,null,intro,sort,author,"T");

        String result= FileUtil.upload(file,request,author);
        if(result.equals("upload-success")){
            bookService.insertBook(book);
            System.out.println("upload-success");
            return ResultUtil.data(null,result);
        }
        else {
            return ResultUtil.error(result);
        }
    }

    //download
    @RequestMapping(value = "/download",method = {RequestMethod.POST})
    public Result download(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(value = "bookName",required = false) String bookName,
                            @RequestParam(value = "author",required = false)String author) throws IOException{
        String fileName = bookName+"BY"+author+".txt";
        System.out.println(fileName);
        String result=FileUtil.download(response, request, fileName);
        if(result.equals("download-success")){
            return ResultUtil.data(null,result);
        }
        else {
            return ResultUtil.error(result);
        }
    }

}
