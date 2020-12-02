package com.home.test;

import com.home.domain.User;
import com.home.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/12/2 16:29
 */
public class MapperTest {
    @Test
    public void test1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        //创建dao层对象
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);

        //模拟ids的数据
        List<Integer> ids= new ArrayList<Integer>();

        ids.add(1);
        ids.add(2);
        ids.add(3);

        List<User> userList = userDao.findByIds(ids);

        System.out.println(userList);
    }
}
