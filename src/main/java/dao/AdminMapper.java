package dao;

import org.apache.ibatis.annotations.Mapper;
import pojo.Admin;

@Mapper
public interface AdminMapper {

    //login
    Admin adminLogin(Admin admin);

}
