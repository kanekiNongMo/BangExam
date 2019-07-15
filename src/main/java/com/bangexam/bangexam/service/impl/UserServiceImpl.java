package com.bangexam.bangexam.service.impl;

import com.bangexam.bangexam.base.result.Result;
import com.bangexam.bangexam.mapper.UserMapper;
import com.bangexam.bangexam.model.User;
import com.bangexam.bangexam.repository.UserRepository;
import com.bangexam.bangexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Result<User> getAllRoleByPage(Integer offset, Integer limit) {
        return Result.success(userMapper.countUser(), userMapper.getAllUserByPage(offset, limit));
    }
}
