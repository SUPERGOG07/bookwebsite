package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.AdminService;
import util.FileUtil;
import util.Result;
import util.ResultUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
public class AdminController {

    @Autowired
    @Qualifier("AdminServiceImpl")
    AdminService adminService;

    //checkBook
    @RequestMapping(value = "/checkbook",method = {RequestMethod.GET})
    public Result checkBook(){
        if(!adminService.checkBook().isEmpty()){
            return ResultUtil.data(adminService.checkBook(),"查看成功");
        }
        return ResultUtil.error("查看失败");
    }

    //pass book
    @RequestMapping(value = "/pass/{bookName}/{author}",method = {RequestMethod.POST})
    public Result pass(@PathVariable String bookName,@PathVariable String author){
        if(adminService.passBook(bookName, author)!=-1){
            return ResultUtil.data(null,"已通过");
        }
        return ResultUtil.error("业务处理失败");
    }

    //noPass
    @RequestMapping(value = "/notpass/{bookName}/{author}",method = {RequestMethod.POST})
    public Result notPass(HttpServletRequest request,@PathVariable String bookName,@PathVariable String author){
        if(adminService.notPassBook(bookName,author)!=-1){
            String result = FileUtil.delete(request, bookName, author);
            if(result.equals("success")){
                return ResultUtil.data(null,"删除成功");
            }
            else return ResultUtil.error(result);
        }
        else return ResultUtil.error("删除失败(或无此书)");
    }


}
