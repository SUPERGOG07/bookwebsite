package service;

import dao.BookMapper;
import pojo.Books;

public class BookServiceImpl implements BookService{

    BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }


}
