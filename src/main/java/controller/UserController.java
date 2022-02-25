package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pojo.Admin;
import pojo.User;
import service.AdminService;
import service.UserService;
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

        if(email.equals("admin")){
            Admin admin=new Admin(email,pwd);
            if(adminService.adminLogin(admin)!=null){
                System.out.println("Admin-Login");
                return ResultUtil.data(admin,"admin");
            }
            else{
                return ResultUtil.error("false");
            }
        }

        User user = new User(0,email,pwd);

        if(userService.login(user)!=null){
            System.out.println("login");
            user.setTleNum(userService.login(user).getTleNum());
            return ResultUtil.data(user);
        }
        else {
            return ResultUtil.error("false");
        }
    }



}
