package service;

import dao.UserMapper;
import org.springframework.transaction.annotation.Transactional;
import pojo.User;

public class UserServiceImpl implements UserService{

    UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional
    @Override
    public User login(String email,String pwd)  throws RuntimeException {
        return userMapper.login(email,pwd);
    }

    @Transactional
    @Override
    public int register(User user) throws RuntimeException {
        return userMapper.register(user);
    }
}
