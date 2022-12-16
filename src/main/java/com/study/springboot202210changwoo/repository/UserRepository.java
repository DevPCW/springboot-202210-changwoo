package com.study.springboot202210changwoo.repository;

import com.study.springboot202210changwoo.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    public int saveUser(UserDto userDto);
    public UserDto findUserById(int userId);
}
