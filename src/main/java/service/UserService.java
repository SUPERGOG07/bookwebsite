package service;


import org.springframework.stereotype.Service;
import pojo.User;


public interface UserService {

    //login
    User login(String email,String pwd);

    //register
    int register(User user);

}
