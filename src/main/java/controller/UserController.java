package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pojo.Admin;
import pojo.User;
import service.AdminService;
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
            User user = new User(0,email,pwd);

            if(userService.login(user)!=null){                              //验证是否是已注册用户
                System.out.println("login");
                user.setTleNum(userService.login(user).getTleNum());
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



}
