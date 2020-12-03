package com.home.mapper;

import com.home.domain.User;

import java.util.List;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/12/3 9:49
 */
public interface UserMapper {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();
}
