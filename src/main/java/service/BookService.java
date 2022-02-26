package service;

import pojo.Books;

import java.util.List;

public interface BookService {
    //select all
    List<Books> selectAllBooks();
}
