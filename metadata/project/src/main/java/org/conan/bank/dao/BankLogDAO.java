//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.bank.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import org.conan.bank.model.BankLogDTO;

/**
 * This is BankLog DAO interface
 * @author Conan Zhang
 * @date 2011-10-10
 */
public interface BankLogDAO extends MybatisDAO {

    int insertBankLog(BankLogDTO dto);
    int deleteBankLog(int id);
    int updateBankLog(BankLogDTO dto);

    BankLogDTO getBankLogById(int id);
    List<BankLogDTO> getBankLogs(Map<String,Object> paramMap);
    int getBankLogsCount(Map<String,Object> paramMap);
}

