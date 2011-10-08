//Create by Conan. E-mail:bsspirit@gmail.com
package com.q24.bank.dao.ibatis;

import java.util.List;
import java.util.Map;
import org.conan.common.dao.ibatis.BaseIbatisDAO;
import org.conan.common.model.PageInObject;
import org.conan.common.model.PageOutObject;

import com.q24.bank.dao.BankDAO;
import com.q24.bank.model.BankDTO;

/**
 * This is Bank DAO implemention
 * @spring.bean id="bankDAO"
 * @spring.property name="dataSource" ref="dataSource"
 * @spring.property name="sqlMapClient" ref="sqlMapClient"
 * @author Conan Zhang
 * @date 2011-09-26
 */
public class BankDAOIbatis extends BaseIbatisDAO implements BankDAO {

    public int insertBank(BankDTO dto) {
        return (Integer) getSqlMapClientTemplate().insert("bank.insertBank", dto);
    }

    public int deleteBank(int id) {
        return getSqlMapClientTemplate().delete("bank.deleteBank", id);
    }

    public int updateBank(BankDTO dto) {
        return getSqlMapClientTemplate().update("bank.updateBank", dto);
    }

    public BankDTO getBankById(int id) {
        return (BankDTO) getSqlMapClientTemplate().queryForObject("bank.getBankById", id);
    }

    public List<BankDTO> getBanks(Map paramMap) {
        return getSqlMapClientTemplate().queryForList("bank.getBanks", paramMap);
    }

    public PageOutObject<BankDTO> getBanksPaging(Map paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<BankDTO> list = getSqlMapClientTemplate().queryForList("bank.getBanks", paramMap);
        int count = (Integer) getSqlMapClientTemplate().queryForObject("bank.getBanksCount", paramMap);
        return new PageOutObject(count, list, page);
    }

}
