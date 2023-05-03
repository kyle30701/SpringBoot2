package com.SpringTest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.SpringTest.entity.User;

@Mapper
public interface userMapper {
	
	//登入
    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    User getInfo(@Param("username") String username, @Param("password") String password);

}
