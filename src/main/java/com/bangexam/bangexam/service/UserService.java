package com.bangexam.bangexam.service;

import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.model.User;

/**
 * @author kaneki
 * @date 2019/7/13 14:24
 */
public interface UserService {

    /**
     * 查询用户,用于用户登录
     *
     * @param user 用户对象
     * @return 用户对象
     */
    User findByUsernameAndPassword(User user);

    Result<User> getAllRoleByPage(Integer offset, Integer limit);
}
