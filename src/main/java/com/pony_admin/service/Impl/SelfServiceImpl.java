package com.pony_admin.service.Impl;

import com.pony_admin.dao.SelfServiceUserDAO;
import com.pony_admin.domain.SelfServiceUser;
import com.pony_admin.domain.User;
import com.pony_admin.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/9
 */
@Service
public class SelfServiceImpl implements SelfService {
    @Autowired
    SelfServiceUserDAO selfServiceUserDAO;

    @Override
    public int insert(SelfServiceUser user) {
        return selfServiceUserDAO.insert(user);
    }

    @Override
    public List<SelfServiceUser> getAll() {
        return selfServiceUserDAO.getAll();
    }

    @Override
    public SelfServiceUser getUserByUserNameAndPassword(String nickname, String password) {
        return selfServiceUserDAO.getUserByUserNameAndPassword(nickname, password);
    }
}
