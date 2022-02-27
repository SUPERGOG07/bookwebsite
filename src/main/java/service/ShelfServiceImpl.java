package service;

import dao.BookMapper;
import dao.ShelfMapper;
import org.springframework.transaction.annotation.Transactional;
import pojo.Books;

import java.util.List;

public class ShelfServiceImpl implements ShelfService{
    ShelfMapper shelfMapper;

    public void setShelfMapper(ShelfMapper shelfMapper) {
        this.shelfMapper = shelfMapper;
    }


    @Transactional
    @Override
    public List<Books> viewShelf(String email) {
        return shelfMapper.viewShelf(email);
    }

    @Transactional
    @Override
    public int shelfAdd(String email, String bookName) {
        if(shelfMapper.shelfCheck(email, bookName)!=null){
            return shelfMapper.shelfAdd(email, bookName);
        }
        else{
            return -1;
        }
    }

    @Transactional
    @Override
    public int shelfDelete(String email, String bookName) {
        if(shelfMapper.shelfCheck(email, bookName)!=null){
            return shelfMapper.shelfDelete(email, bookName);
        }
        else{
            return -1;
        }
    }
}
