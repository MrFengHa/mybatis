package com.home.mapper;

import com.home.domain.Order;

import java.util.List;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/12/3 9:49
 */
public interface OrderMapper {
    /**
     * 返回所有订单
     * @return
     */
    List<Order> findAll();
}
