package com.bangexam.bangexam.mapper;

import com.bangexam.bangexam.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author kaneki
 * @date 2019/7/13 16:52
 */
@Mapper
public interface UserMapper {

    /**
     * 查询 exam_user表的总条数
     * @return
     */
    @Select("select count(*) from exam_user")
    Integer countUser();

    /**
     * 分页
     * offset：从第几条开始
     * limit： 返回几条数据
     * @return
     */
    @Select("select user_id as id, user_name as username, password as password, user_status as status from exam_user " +
            "order by user_id limit #{offset}, #{limit}")
    List<User> getAllUserByPage(@Param("offset") Integer offset, @Param("limit") Integer limit);

    //用户名中有name的有多少条
    @Select("select count(*) from exam_user where user_name like '%${username}%'")
    int findUserByUserNameCount(@Param("username") String username);

    //搜索分页
    @Select("select user_id as id, user_name as username, password as password, user_status as status from exam_user " +
            "where user_name like '%${username}%' limit #{offset}, #{limit}")
    List<User> findUserByUserNameByPage(@Param("username") String username, @Param("offset") Integer offset,
                                        @Param("limit") Integer limit);

    //查询用户是否存在
    @Select("select user_id as id, user_name as username, password as password, user_status as status from exam_user where user_name = #{username}")
    User findByUserName(@Param("username") String username);

    //添加用户
    @Insert("insert into exam_user(user_name, password, user_status) values(#{username}, #{password}, #{status})")
    int seveUser(User user);

    //删除用户
    @Delete("delete from exam_user where user_id = #{id}")
    int deleteUser(Integer id);

    //更新查询用户
    @Select("select user_id as id, user_name as username, password as password, user_status as status from exam_user " +
            "where user_id = #{id}")
    User findById(Integer id);

    //修改密码
    @Update("update exam_user set password = #{password} where user_id = #{id}")
    int changePassword(@Param("id") Integer id, @Param("password") String newPassword);

    int delAll(List<Integer> id);
}
