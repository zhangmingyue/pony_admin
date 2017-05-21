package com.pony_admin.service;

import com.pony_admin.domain.SelfServiceUser;
import com.pony_admin.domain.User;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/9
 */
public interface SelfService {

    int insert(SelfServiceUser user);

    List<SelfServiceUser> getAll();

    SelfServiceUser getUserByUserNameAndPassword(String nickname, String password);
}
