package com.pony_admin.service;

import com.pony_admin.domain.User;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/9
 */
public interface PermissionService {

    List<User> getAll();

    User getUserByUserNameAndPassword(String nickname, String password);
}
