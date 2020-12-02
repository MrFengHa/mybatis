package com.home.mapper;

import com.home.domain.User;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/12/2 20:57
 */
public interface UserMapper {
    /**
     * 保存
     * @param user
     */
    void save(User user);

    /**
     * 根据参数查找
     * @param id
     */
    User findById(int id);
}
