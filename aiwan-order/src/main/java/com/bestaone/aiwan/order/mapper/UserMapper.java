package com.bestaone.aiwan.order.mapper;

import com.bestaone.aiwan.order.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(id,name,username,password,tel,gender,createTime) VALUES(#{id},#{name},#{username},#{password},#{tel},#{gender},#{createTime})")
    void insert(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void delete(Long id);

    @Update("UPDATE user SET name=#{name},username=#{username},password=#{password},tel=#{tel},gender=#{gender},createTime=#{createTime} WHERE id =#{id}")
    int update(User user);

    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM user WHERE id=#{id}")
    User findById(Long id);

    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM user WHERE username=#{username}")
    User findByUsername(String username);

    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM user WHERE tel=#{tel}")
    User findByTel(String tel);

    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM user")
    List<User> findAll();

    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM user WHERE name like #{name}")
    List<User> findByName(String name);

}