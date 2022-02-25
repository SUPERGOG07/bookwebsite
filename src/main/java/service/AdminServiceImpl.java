package service;

import dao.AdminMapper;
import pojo.Admin;

public class AdminServiceImpl implements AdminService{

    AdminMapper adminMapper;

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public Admin adminLogin(Admin admin) {
        return adminMapper.adminLogin(admin);
    }
}
