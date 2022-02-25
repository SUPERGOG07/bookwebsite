package service;

import dao.UserMapper;
import pojo.User;

public class UserServiceImpl implements UserService{

    UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
