package service;

import pojo.Books;

import java.util.List;

public interface ShelfService {

    //view shelf
    List<Books> viewShelf(String email);

    //shelf add
    int shelfAdd(String email,String bookName,String author);

    //shelf delete
    int shelfDelete(String email,String bookName,String author);
}
