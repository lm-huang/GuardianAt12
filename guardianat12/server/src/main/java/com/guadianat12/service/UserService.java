package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

public interface UserService {
    /**
     * desc 微信登录
     * @param  userLoginDTO
     * @return null
     **/
    User wxLogin(UserLoginDTO userLoginDTO);
}
