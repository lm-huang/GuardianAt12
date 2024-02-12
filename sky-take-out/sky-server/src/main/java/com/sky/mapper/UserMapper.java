package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @program: sky-take-out
 * @description:
 * @author: Liming Huang
 * @create-time: 2024-01-17 21:26
 **/
@Mapper
public interface UserMapper {
    /**
     * desc 根据openid来查用户
     * @param openid
     * @return null
     **/
    @Select("select * from user where openid=#{openid}")
    User getByOpenid(String openid);

    void insert(User user);
}
