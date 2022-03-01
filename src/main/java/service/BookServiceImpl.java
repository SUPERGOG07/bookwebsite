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
    public int insertBook(Books book) {
        return bookMapper.insertBook(book);
    }

    @Transactional
    @Override
    public List<Books> search(String likeName) {
        String newLikeName = "%"+likeName+"%";
        if(!bookMapper.bookLikeName(newLikeName).isEmpty()){
            return bookMapper.bookLikeName(newLikeName);
        }
        else if(!bookMapper.bookLikeAuthor(newLikeName).isEmpty()){
            return bookMapper.bookLikeAuthor(newLikeName);
        }
        else return null;
    }

    @Transactional
    @Override
    public List<Books> checkBook(String bookName, String author) {
        return bookMapper.checkBook(bookName,author);
    }

    @Transactional
    @Override
    public int riseHot(String bookName, String author) {
        return bookMapper.riseHot(bookName, author);
    }

    @Override
    public List<Books> selectByHot() {
        return bookMapper.selectByHot();
    }
}
