//Create by Conan. E-mail:bsspirit@gmail.com
package com.q24.bank.dao.ibatis;

import java.util.List;
import java.util.Map;
import org.conan.common.dao.ibatis.BaseIbatisDAO;
import org.conan.common.model.PageInObject;
import org.conan.common.model.PageOutObject;

import com.q24.bank.dao.BankLogDAO;
import com.q24.bank.model.BankLogDTO;

/**
 * This is BankLog DAO implemention
 * @spring.bean id="bankLogDAO"
 * @spring.property name="dataSource" ref="dataSource"
 * @spring.property name="sqlMapClient" ref="sqlMapClient"
 * @author Conan Zhang
 * @date 2011-09-26
 */
public class BankLogDAOIbatis extends BaseIbatisDAO implements BankLogDAO {

    public int insertBankLog(BankLogDTO dto) {
        return (Integer) getSqlMapClientTemplate().insert("bankLog.insertBankLog", dto);
    }

    public int deleteBankLog(int id) {
        return getSqlMapClientTemplate().delete("bankLog.deleteBankLog", id);
    }

    public int updateBankLog(BankLogDTO dto) {
        return getSqlMapClientTemplate().update("bankLog.updateBankLog", dto);
    }

    public BankLogDTO getBankLogById(int id) {
        return (BankLogDTO) getSqlMapClientTemplate().queryForObject("bankLog.getBankLogById", id);
    }

    public List<BankLogDTO> getBankLogs(Map paramMap) {
        return getSqlMapClientTemplate().queryForList("bankLog.getBankLogs", paramMap);
    }

    public PageOutObject<BankLogDTO> getBankLogsPaging(Map paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<BankLogDTO> list = getSqlMapClientTemplate().queryForList("bankLog.getBankLogs", paramMap);
        int count = (Integer) getSqlMapClientTemplate().queryForObject("bankLog.getBankLogsCount", paramMap);
        return new PageOutObject(count, list, page);
    }

}
