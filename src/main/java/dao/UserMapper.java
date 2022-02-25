package dao;

import org.apache.ibatis.annotations.Mapper;
import pojo.User;

@Mapper
public interface UserMapper {

    //login
    User login(User user);

    //register



}
