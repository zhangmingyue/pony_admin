package com.pony_admin.service.Impl;

import com.pony_admin.dao.UserDAO;
import com.pony_admin.domain.User;
import com.pony_admin.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/9
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    UserDAO userDAO;

    @Override
    public int insert(User user) {
        return userDAO.insert(user);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public User getUserByUserNameAndPassword(String nickname, String password) {
        return userDAO.getUserByUserNameAndPassword(nickname, password);
    }
}
