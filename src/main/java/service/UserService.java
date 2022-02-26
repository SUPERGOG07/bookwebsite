package service;



import pojo.User;


public interface UserService {

    //login
    User login(String email,String pwd);

    //register
    int register(User user);

    //check
    User checkUser(String email);
}
