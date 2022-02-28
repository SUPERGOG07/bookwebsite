package dao;

import org.apache.ibatis.annotations.Mapper;
import pojo.Admin;
import pojo.Books;

import java.util.List;

@Mapper
public interface AdminMapper {

    //login
    Admin adminLogin(Admin admin);

}
