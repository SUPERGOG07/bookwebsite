package service;

import org.apache.ibatis.annotations.Param;
import pojo.Books;

import java.util.List;

public interface BookService {
    //select all
    List<Books> selectAllBooks();

    //select by sort
    List<Books> selectBookBySort(String sort);

    //limit select
    List<Books> selectBookByLimit(int startIndex,int pageSize);

    //add book
    int insertBook(Books book);

    //search
    List<Books> search(String likeName);

    //check book
    List<Books> checkBook( String bookName, String author);
}
