package service;

import org.apache.ibatis.annotations.Param;
import pojo.Books;

import java.util.List;

public interface BookService {
    //select all
    List<Books> selectAllBooks();

    //select by sort
    List<Books> selectBookBySort(String sort);

    //add book
    int insertBook(Books book);

    //search
    List<Books> search(String likeName);

    //check book
    List<Books> checkBook( String bookName, String author);

    //rise hot
    int riseHot(String bookName,String author);

    //select by hot
    List<Books> selectByHot();

    //setUrl
    int setUrl(String bookName,String author,String url);

    //getUrl
    String getUrl(String bookName,String author);
}
