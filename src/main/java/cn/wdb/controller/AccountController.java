package cn.wdb.controller;

import cn.wdb.domain.Account;
import cn.wdb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 控制器
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/findAll")
    public String findAll(){
//        System.out.println("springMVC环境搭建成功");
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        return "list";
    }

    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.save(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }
}
