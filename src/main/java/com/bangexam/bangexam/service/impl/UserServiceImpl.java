package com.bangexam.bangexam.service.impl;

import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.mapper.UserMapper;
import com.bangexam.bangexam.model.User;
import com.bangexam.bangexam.repository.UserRepository;
import com.bangexam.bangexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author kaneki
 * @date 2019/7/13 14:24
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsernameAndPassword(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    //用户分页
    @Override
    public Result<User> getAllRoleByPage(Integer offset, Integer limit) {
        return Result.success(userMapper.countUser(), userMapper.getAllUserByPage(offset, limit));
    }

    //搜索分页
    @Override
    public Result<User> findUserByUserName(String username, Integer offset, Integer limit) {
        return Result.success(userMapper.findUserByUserNameCount(username), userMapper.findUserByUserNameByPage(username, offset, limit));
    }

    //查询用户是否存在
    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    //添加用户
    @Override
    public Result seveUser(User user) {
        return userMapper.seveUser(user) > 0 ? Result.success() : Result.failure();
    }

    //删除用户
    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    //更新查询用户
    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    //修改密码
    @Override
    public Result<User> newPassword(String username, String oldPassword, String newPassword) {
        User user = userMapper.findByUserName(username);
        System.out.println("user = " +user);
        if (user == null) {
            return Result.failure(1,"用户不存在");
        }
        if (! user.getPassword().equals(oldPassword)) {
            return Result.failure(1,"旧密码错误");
        }
        System.out.println(userMapper.changePassword(user.getId(), newPassword));
        return userMapper.changePassword(user.getId(), newPassword) > 0 ? Result.success() : Result.failure();
    }

    @Override
    public Result delAll(List<Integer> id) {
        return userMapper.delAll(id) > 0 ? Result.success() : Result.failure();
    }
}
