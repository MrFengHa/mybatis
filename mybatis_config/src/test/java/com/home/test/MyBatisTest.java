package com.home.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.home.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/12/2 22:36
 */
public class MyBatisTest {

    InputStream resInputStream;
    SqlSessionFactory sessionFactory;
    SqlSession sqlSession;
    UserMapper userMapper;

    @Before
    public void init() throws IOException {
        //获得核心配置文件
        resInputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得工厂
        sessionFactory = new SqlSessionFactoryBuilder().build(resInputStream);
        //获得会话对象
        sqlSession = sessionFactory.openSession();

        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    /**
     * 保存
     */
    @Test
    public void saveTest() {
        User user = new User(7, "ceshi", "abc", new Date());
        userMapper.save(user);
    }

    @Test
    public void selectByIdTest() {
        User user = userMapper.findById(7);
        System.out.println(user.getBirthday());
        System.out.println(user);
    }

    @Test
    public void findAll() {
        //设置分页的相关参数  当前页 每页显示的条数
        PageHelper.startPage(1,3);

        List<User> users= userMapper.findAll();
        for (User user:
             users) {
            System.out.println(user);
        }
        //获得与分页相关的参数
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        System.out.println("获取当前页"+ pageInfo.getPageNum());

        System.out.println("每页显示条数"+pageInfo.getPageSize());
        System.out.println("总条数"+pageInfo.getTotal());
        System.out.println("总页数"+pageInfo.getPages());
        System.out.println("上一页"+pageInfo.getPrePage());
        System.out.println("下一页"+pageInfo.getNextPage());
        System.out.println("是否是第一个"+pageInfo.isIsFirstPage());
        System.out.println("是否是最后一个"+pageInfo.isIsLastPage());



    }

    @After
    public void destroy() {
        sqlSession.commit();
        sqlSession.close();
    }
}
