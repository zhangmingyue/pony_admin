package com.pony_admin.dao;

import com.pony_admin.domain.SelfServiceUser;
import com.pony_admin.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/10
 */
public interface SelfServiceUserDAO {

    int insert(SelfServiceUser user);

    List<SelfServiceUser> getAll();

    SelfServiceUser getUserByUserNameAndPassword(@Param("nickname") String nickname,
                                      @Param("password") String password);
}
