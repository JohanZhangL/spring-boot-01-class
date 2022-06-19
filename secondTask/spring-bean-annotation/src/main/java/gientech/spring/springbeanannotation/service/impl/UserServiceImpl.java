package gientech.spring.springbeanannotation.service.impl;

import gientech.spring.springbeanannotation.dao.UserDao;
import gientech.spring.springbeanannotation.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name  = "userDao")
    private UserDao userDao;

    @Override
    public void save(){
        userDao.save();
    }

}