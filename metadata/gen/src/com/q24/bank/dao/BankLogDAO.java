//Create by Conan. E-mail:bsspirit@gmail.com
package com.q24.bank.dao;

import java.util.List;
import java.util.Map;
import com.q24.base.dao.MybatisDAO;
import com.q24.base.dao.PageInObject;
import com.q24.base.dao.PageOutObject;

import com.q24.bank.model.BankLogDTO;

/**
 * This is BankLog DAO interface
 * @author Conan Zhang
 * @date 2011-09-26
 */
public interface BankLogDAO extends MybatisDAO {

    int insertBankLog(BankLogDTO dto);
    int deleteBankLog(int id);
    int updateBankLog(BankLogDTO dto);

    BankLogDTO getBankLogById(int id);
    List<BankLogDTO> getBankLogs(Map<String,Object> paramMap);
    PageOutObject<BankLogDTO> getBankLogsPaging(Map<String,Object> paramMap, PageInObject page);
    int getBankLogsCount(Map<String,Object> paramMap);
}

