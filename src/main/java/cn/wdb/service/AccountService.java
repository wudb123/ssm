package cn.wdb.service;

import cn.wdb.domain.Account;

import java.util.List;

/**
 * 业务层接口
 */
public interface AccountService {
    /**
     *  查询所有
     */
    public List<Account> findAll();

    /**
     * 保存
     */
    public void save(Account account);
}
