package service;


import org.springframework.stereotype.Service;
import pojo.User;


public interface UserService {

    //login
    User login(User user);


}
