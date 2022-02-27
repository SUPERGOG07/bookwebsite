package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Books;

import java.util.List;

public interface ShelfMapper {


    //view shelf
    List<Books> viewShelf(String email);

    //shelf add
    int shelfAdd(@Param("email") String email,@Param("bookName") String bookName);

    //check shelf
    String shelfCheck(@Param("email") String email,@Param("bookName") String bookName);

    //shelf delete
    int shelfDelete(@Param("email") String email,@Param("bookName") String bookName);

}
