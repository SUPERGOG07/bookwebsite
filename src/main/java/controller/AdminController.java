package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AdminService;
import util.Result;
import util.ResultUtil;

@RestController
public class AdminController {

    @Autowired
    @Qualifier("AdminServiceImpl")
    AdminService adminService;

    @RequestMapping(value = "/checkbook/{index}")
    public Result checkBook(@PathVariable int index){
        if(!adminService.checkBook(index).isEmpty()){
            return ResultUtil.data(adminService.checkBook(index),"check-success");
        }
        return ResultUtil.error("check-failed");
    }


}
