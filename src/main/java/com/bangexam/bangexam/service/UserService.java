package com.bangexam.bangexam.service;

import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.model.User;

import java.util.List;

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

    /**
     * 用户分页
     * @param offset： 从从第几条开始
     * @param limit： 返回几条数据
     * @return
     */
    Result<User> getAllRoleByPage(Integer offset, Integer limit);

    /**
     * 搜索查询
     * @param username：输入的name
     * @param offset
     * @param limit
     * @return
     */
    Result<User> findUserByUserName(String username, Integer offset, Integer limit);

    //查询用户是否存在
    User findByUserName(String username);

    //进行添加用户
    Result seveUser(User user);

    int deleteUser(Integer id);

    User findById(Integer id);

    Result<User> newPassword(String username, String oldPassword, String newPassword);

    Result delAll(List<Integer> id);
}
