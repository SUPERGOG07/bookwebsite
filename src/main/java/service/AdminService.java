package service;

import pojo.Admin;
import pojo.Books;

import java.util.List;

public interface AdminService {
    //login
    Admin adminLogin(Admin admin);

    //check book
    List<Books> checkBook();

    //check book -- pass
    int passBook(String bookName,String author);

    //check book -- not pass
    int notPassBook(String bookName,String author);
}
