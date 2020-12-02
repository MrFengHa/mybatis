package com.home.mapper;

import com.home.domain.User;

import java.util.List;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/12/2 15:42
 */
public interface UserMapper {
    /**
     * 查询User全部
     * @return
     */
    List<User> findAll();

    /**
     * 查询id所属的用户
     * @param id
     * @return
     */
    User findById(int id);
}
