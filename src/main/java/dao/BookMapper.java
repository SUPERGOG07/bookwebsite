package dao;

import org.apache.ibatis.annotations.Mapper;
import pojo.Books;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {

    //select all
    List<Books> selectAllBooks();

    //select by name
    List<Books> selectBookByName(String name);

    //select by sort
    List<Books> selectBookBySort(String sort);

    //add book
    int insertBook(Books book);

    //delete book
    int deleteBook(String name);

    //update book
    int updateBook(Books book);

    //limit select book
    List<Books> selectBookByLimit(Map<String,Integer> map);

}
