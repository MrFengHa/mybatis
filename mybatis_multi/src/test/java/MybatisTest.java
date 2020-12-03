import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.home.domain.Order;
import com.home.domain.User;
import com.home.mapper.OrderMapper;
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
import java.util.List;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/12/3 10:53
 */
public class MybatisTest {
    InputStream resInputStream;
    SqlSessionFactory sessionFactory;
    SqlSession sqlSession;
    UserMapper userMapper;
    OrderMapper orderMapper;

    @Before
    public void init() throws IOException {
        //获得核心配置文件
        resInputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得工厂
        sessionFactory = new SqlSessionFactoryBuilder().build(resInputStream);
        //获得会话对象
        sqlSession = sessionFactory.openSession();

        userMapper = sqlSession.getMapper(UserMapper.class);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    /**
     * 一对一查询
     */
    @Test
    public void findAllOneOnOneTest() {
        List<Order> orderList = orderMapper.findAll();
        for (Order order :
                orderList) {
            System.out.println(order);
        }
    }

    /**
     * 一对多查询
     */
    @Test
    public void findAllOneOnMore(){
        List<User> users = userMapper.findAll();
        for (User user:
             users) {
            System.out.println(user);
        }
    }

    /**
     * 多对多查询
     */
    @Test
    public void findAllMoreOnMore(){
        List<User> users = userMapper.findUserAndRole();
        for (User user:
                users) {
            System.out.println(user);
        }
    }


    @After
    public void destroy() {
        sqlSession.commit();
        sqlSession.close();
    }
}
