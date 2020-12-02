package com.home.test;

import com.home.domain.User;
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
    public void saveTest(){
        User user = new User(7,"ceshi","abc",new Date());
        userMapper.save(user);
    }
    @Test
    public void selectTest(){
        User user = userMapper.findById(7);
        System.out.println(user.getBirthday());
        System.out.println(user);
    }


    @After
    public void destroy() {
        sqlSession.commit();
        sqlSession.close();
    }
}
