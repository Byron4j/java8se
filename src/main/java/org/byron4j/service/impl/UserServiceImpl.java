package org.byron4j.service.impl;

import org.byron4j.beans.UserBean;
import org.byron4j.mapper.UserMapper;
import org.byron4j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean save(UserBean userBean) {
        int cnt = userMapper.insert(userBean);
        return cnt > 0;
    }

    @Override
    public List<UserBean> list() {
        return userMapper.selectList(null);
    }


}
