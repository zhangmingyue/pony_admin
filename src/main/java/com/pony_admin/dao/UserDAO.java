package com.pony_admin.dao;

import com.pony_admin.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/10
 */
public interface UserDAO {

    List<User> getAll();

    User getUserByUserNameAndPassword(@Param("nickname") String nickname,
                                      @Param("password") String password);
}
