package com.home.mapper;

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


    /**
     * 根据条件查询
     * @param user
     * @return
     */
    List<User> findByCondition(User user);

    /**
     *
     * @return
     */
    List<User> findByIds(List<Integer> ids);
}
