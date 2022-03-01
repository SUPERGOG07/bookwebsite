package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import pojo.Admin;
import pojo.User;
import service.AdminService;
import service.BookService;
import service.ShelfService;
import service.UserService;
import util.RegexUtil;
import util.Result;
import util.ResultUtil;



@RestController
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminService adminService;

    @Autowired
    @Qualifier("ShelfServiceImpl")
    private ShelfService shelfService;

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //login
    @RequestMapping(value = "/login/{email}/{pwd}",method = {RequestMethod.POST})
    public Result login(@PathVariable String email, @PathVariable String pwd)  {
        System.out.println(email+"  "+pwd);

        if(email.equals("admin")){                              //验证是否是管理员邮箱
            Admin admin=new Admin(email,pwd);
            if(adminService.adminLogin(admin)!=null){                //验证是否是管理员
                System.out.println("Admin-Login");
                return ResultUtil.data(admin,"管理员登陆成功");          //如果是，返回msg:admin
            }
            else{
                return ResultUtil.error("管理员登陆失败");               //如果不是，返回error
            }
        }

        if(RegexUtil.emailRegex(email)){                        //不是管理员，则验证邮箱正则
            if(userService.login(email, pwd)!=null){                              //验证是否是已注册用户
                System.out.println("user-login");
                User user=new User(userService.login(email, pwd).getTleNum(),email,pwd);
                return ResultUtil.data(user);                               //是，返回用户信息
            }
            else {
                if(userService.checkUser(email)!=null){
                    return ResultUtil.error("密码错误");
                }
                return ResultUtil.error("用户不存在");                      //不是，返回error
            }
        }
        else{
            return ResultUtil.error("邮箱格式错误");          //邮箱格式错误，报错
        }
    }


    //register
    @RequestMapping(value = "/register/{tleNum}/{email}/{pwd}",method = {RequestMethod.POST})
    public Result register(@PathVariable("tleNum") String tleNum,@PathVariable("email") String email,@PathVariable("pwd") String pwd){
        System.out.println(tleNum+" "+email+" "+pwd);

        if(RegexUtil.tleAndEmailAndPwdRegex(tleNum,email,pwd).equals("true")){
            System.out.println("regex-yes");
            if(userService.checkUser(email)!=null){
                return ResultUtil.error("邮箱已注册");
            }
            User user=new User(tleNum,email,pwd);
            if(userService.register(user)!=-1){
                System.out.println(email+"  "+"register successfully");
                return ResultUtil.data(null,"注册成功");
            }
            return ResultUtil.error("注册失败");
        }
        else {
            return ResultUtil.error(RegexUtil.tleAndEmailAndPwdRegex(tleNum, email, pwd)+"错误");
        }
    }

    //view shelf
    @RequestMapping(value = "/shelf/view/{email}",method = {RequestMethod.POST})
    public Result viewShelf(@PathVariable String email){
        System.out.println("shelf-view");

        if(!shelfService.viewShelf(email).isEmpty()){
            return ResultUtil.data(shelfService.viewShelf(email),"查看成功");
        }
        return ResultUtil.error("找不到书");
    }

    //shelf add
    @RequestMapping(value = "/shelf/add/{email}/{bookName}/{author}",method = {RequestMethod.POST})
    public Result shelfAdd(@PathVariable String email,@PathVariable String bookName,@PathVariable String author){
        System.out.println(email+"  "+bookName+" "+author);
        System.out.println("shelf-add");
        if(shelfService.shelfAdd(email, bookName,author)!=-1){
            return ResultUtil.data(null,"添加成功");
        }
        else if(shelfService.shelfAdd(email, bookName, author)==-1){
            return ResultUtil.error("书架有这本书了");
        }
        return ResultUtil.error("添加失败");
    }

    //shelf delete
    @RequestMapping(value = "/shelf/delete/{email}/{bookName}/{author}",method = {RequestMethod.POST})
    public Result shelfDelete(@PathVariable String email,@PathVariable String bookName,@PathVariable String author){
        System.out.println("shelf-delete");
        if(shelfService.shelfDelete(email, bookName,author)!=-1){
            return ResultUtil.data(null,"书架删除成功");
        }
        return ResultUtil.data("书架删除失败");
    }

    //search
    @RequestMapping(value = "/search/{likeName}",method = {RequestMethod.GET})
    public Result bookSearch(@PathVariable String likeName){
        System.out.println("search:"+likeName);
        if(bookService.search(likeName)!=null){
            return ResultUtil.data(bookService.search(likeName),"查询成功");
        }
        else return ResultUtil.error("查询失败");
    }


}
