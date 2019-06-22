package cn.wdb.dao;

import cn.wdb.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 帐户持久层接口
 */
@Repository
public interface AccountDao {
    /**
     *  查询所有
     */
    @Select("select * from account" )
    public List<Account> findAll();

    /**
     * 保存
     */
    @Insert(value = "insert into account(name,money) values(#{name},#{money})")
    public void save(Account account);
}
