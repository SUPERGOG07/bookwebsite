package service;

import pojo.Books;

import java.util.List;

public interface BookService {
    //select all
    List<Books> selectAllBooks();

    //select by sort
    List<Books> selectBookBySort(String sort);

    //limit select
    List<Books> selectBookByLimit(int startIndex,int pageSize);
}
