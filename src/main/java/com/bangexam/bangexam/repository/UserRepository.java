package com.bangexam.bangexam.repository;

import com.bangexam.bangexam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kaneki
 * @date 2019/7/13 14:20
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    User findByUsernameAndPassword(String username, String password);
}
