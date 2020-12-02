package com.home.test;

import com.home.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/12/2 12:13
 */
public class MyBatisTest {
    InputStream resInputStream;
    SqlSessionFactory sessionFactory;
    SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        //获得核心配置文件
        resInputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得工厂
        sessionFactory = new SqlSessionFactoryBuilder().build(resInputStream);
        //获得会话对象
        sqlSession = sessionFactory.openSession();
    }

    /**
     * 查询操作
     */
    @Test
    public void selectTest(){
        //执行操作 参数：namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        System.out.println(userList);
    }

    /**
     * 出入操作
     */
    @Test
    public void saveTest(){

        //执行操作
        User user = new User(7,"chouchou","123");
        int count = sqlSession.insert("userMapper.save", user);
        System.out.println(count);
    }

    /**
     * 修改操作
     */
    @Test
    public void updateTest(){

        //执行操作
        User user = new User(6,"susu","123");
        int count = sqlSession.update("userMapper.update", user);
        System.out.println(count);
    }
    /**
     * 删除操作
     */
    @Test
    public void deleteTest(){

        //执行操作
        int count = sqlSession.delete("userMapper.delete", 7);
        System.out.println(count);
    }




    @After
    public void destroy() {
        sqlSession.commit();
        sqlSession.close();
    }
}
