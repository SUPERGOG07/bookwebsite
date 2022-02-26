package service;

import dao.BookMapper;
import org.springframework.transaction.annotation.Transactional;
import pojo.Books;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Transactional
    @Override
    public List<Books> selectBookBySort(String sort) {
        return bookMapper.selectBookBySort(sort);
    }

    @Transactional
    @Override
    public List<Books> selectBookByLimit(int startIndex, int pageSize) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",startIndex-1);
        map.put("pageSize",pageSize);
        return bookMapper.selectBookByLimit(map);
    }
}
