package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.User;

@Mapper
public interface UserMapper {

    //login
    User login(@Param("email") String email, @Param("pwd") String pwd);

    //register
    int register(User user);

    //check
    User checkUser(@Param("email") String email);
}
