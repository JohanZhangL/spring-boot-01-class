package gientech.spring.springbeanannotation.dao.impl;

import gientech.spring.springbeanannotation.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save(){
        System.out.println("save.");
    }
}
