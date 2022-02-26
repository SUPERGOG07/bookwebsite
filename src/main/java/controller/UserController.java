package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pojo.Admin;
import pojo.User;
import service.AdminService;
import service.UserService;
import service.UserServiceImpl;
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

    //login
    @RequestMapping(value = "/login/{email}/{pwd}",method = {RequestMethod.POST})

    public Result login(@PathVariable String email, @PathVariable String pwd)  {
        System.out.println(email+"  "+pwd);

        if(email.equals("admin")){                              //验证是否是管理员邮箱
            Admin admin=new Admin(email,pwd);
            if(adminService.adminLogin(admin)!=null){                //验证是否是管理员
                System.out.println("Admin-Login");
                return ResultUtil.data(admin,"admin");          //如果是，返回msg:admin
            }
            else{
                return ResultUtil.error("false");               //如果不是，返回error
            }
        }

        if(RegexUtil.emailRegex(email)){                        //不是管理员，则验证邮箱正则
            if(userService.login(email, pwd)!=null){                              //验证是否是已注册用户
                System.out.println("login");
                User user=new User(userService.login(email, pwd).getTleNum(),email,pwd);
                return ResultUtil.data(user);                               //是，返回用户信息
            }
            else {
                return ResultUtil.error("false");                      //不是，返回error
            }
        }
        else{
            return ResultUtil.error("邮箱格式错误");          //邮箱格式错误，报错
        }
    }


    //register
    @RequestMapping("/register/{tleNum}/{email}/{pwd}")
    public Result register(@PathVariable int tleNum,@PathVariable String email,@PathVariable String pwd){
        System.out.println(tleNum+" "+email+" "+pwd);

        if(RegexUtil.tleAndEmailAndPwdRegex(tleNum,email,pwd)){
            User user=new User(tleNum,email,pwd);
            if(userService.register(user)!=-1){
                System.out.println(email+"register successfully");
                return ResultUtil.data(null,"注册成功");
            }
            return ResultUtil.error("注册失败");
        }
        else {
            return ResultUtil.error("格式错误，清检查格式");
        }
    }




}
