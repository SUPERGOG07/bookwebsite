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
        Books book = new Books(name,null,intro,sort,author,"T",0);

        String result= FileUtil.upload(file,request);
        if(result.equals("400")){
            return ResultUtil.error("空文件异常");
        }else if(result.equals("500")){
            return ResultUtil.error("上传失败");
        }else if (result.equals("401")){
            return ResultUtil.error("文件格式不符");
        }
        else {
            bookService.insertBook(book);
            bookService.setUrl(name,author,result);
            System.out.println("upload-success");
            return ResultUtil.data(null," 上传成功");
        }
    }

    //download
    @RequestMapping(value = "/download",method = {RequestMethod.POST})
    public Result download(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(value = "bookName",required = false) String bookName,
                            @RequestParam(value = "author",required = false)String author) throws IOException{
        String fileName = bookService.getUrl(bookName,author);
        System.out.println(fileName);
        String result=FileUtil.download(response, request, fileName);
        if(result.equals("download-success")){
            bookService.riseHot(bookName, author);
            return ResultUtil.data(null,result);
        }
        else {
            return ResultUtil.error(result);
        }
    }

}
