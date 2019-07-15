package com.bangexam.bangexam.mapper;

import com.bangexam.bangexam.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author kaneki
 * @date 2019/7/13 16:52
 */
@Mapper
public interface UserMapper {

    @Select("select count(*) from exam_user")
    Integer countUser();

    @Select("select user_id as id, user_name as username, password as password, user_status as status from exam_user " +
            "order by user_id limit #{offset}, #{limit}")
    List<User> getAllUserByPage(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
