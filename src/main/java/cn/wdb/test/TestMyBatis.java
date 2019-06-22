package cn.wdb.test;

import cn.wdb.dao.AccountDao;
import cn.wdb.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试mybatis
 */
public class TestMyBatis {
    /**
     * 测试查询
     * @throws Exception
     */
    @Test
    public void run() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSessionFactory工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        //获取sqlSession对象
        SqlSession session = sessionFactory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //调用方法
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        session.close();
        in.close();
    }

    /**
     * 测试保存
     * @throws Exception
     */
    @Test
    public void run1() throws Exception {
        Account account = new Account();
        account.setName("王五");
        account.setMoney(200d);
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSessionFactory工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        //获取sqlSession对象
        SqlSession session = sessionFactory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //调用方法
        dao.save(account);
        session.close();
        in.close();
    }

}
