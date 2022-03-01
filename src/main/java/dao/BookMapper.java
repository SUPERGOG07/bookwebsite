package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Books;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {

    //select all
    List<Books> selectAllBooks();

    //check book
    List<Books> checkBook(@Param("bookName") String bookName, @Param("author") String author);

    //select by sort
    List<Books> selectBookBySort(String sort);

    //add book
    int insertBook(Books book);

    //limit select book
    List<Books> selectBookByLimit(Map<String,Integer> map);

    //select like name
    List<Books> bookLikeName(String likeName);

    //select like author
    List<Books> bookLikeAuthor(String likeName);
}
