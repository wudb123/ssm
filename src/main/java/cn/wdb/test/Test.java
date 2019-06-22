package cn.wdb.test;

import cn.wdb.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试
 */
public class Test {
    @org.junit.Test
    public void run1(){
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //得到对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //调用findAll方法
        as.findAll();
    }
}
