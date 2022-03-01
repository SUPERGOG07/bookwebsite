package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Admin;
import pojo.Books;

import java.util.List;

@Mapper
public interface AdminMapper {

    //login
    Admin adminLogin(Admin admin);

    //check book
    List<Books> checkBook();

    //check book -- pass
    int passBook(@Param("bookName") String bookName,@Param("author") String author);

    //check book -- not pass
    int notPassBook(@Param("bookName") String bookName,@Param("author")String author);
}
