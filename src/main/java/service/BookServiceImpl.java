package service;

import dao.BookMapper;
import org.springframework.transaction.annotation.Transactional;
import pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{

    BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Transactional
    @Override
    public List<Books> selectAllBooks() {
        return bookMapper.selectAllBooks();
    }
}
