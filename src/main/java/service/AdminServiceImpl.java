package service;

import dao.AdminMapper;
import org.springframework.transaction.annotation.Transactional;
import pojo.Admin;
import pojo.Books;

import java.util.List;

public class AdminServiceImpl implements AdminService{

    AdminMapper adminMapper;

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Transactional
    @Override
    public Admin adminLogin(Admin admin) {
        return adminMapper.adminLogin(admin);
    }

    @Transactional
    @Override
    public List<Books> checkBook(int index) {
        return adminMapper.checkBook(index);
    }

    @Transactional
    @Override
    public int passBook(String bookName,String author) {
        return adminMapper.passBook(bookName,author);
    }

    @Transactional
    @Override
    public int notPassBook(String bookName,String author) {
        return adminMapper.notPassBook(bookName,author);
    }
}
