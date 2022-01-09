package org.byron4j.service;

import org.byron4j.beans.UserBean;

import java.util.List;

public interface UserService {
    boolean save(UserBean userBean);

    List<UserBean> list();
}
