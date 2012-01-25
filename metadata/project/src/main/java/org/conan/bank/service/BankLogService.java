//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.bank.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import org.conan.bank.model.BankLogDTO;

/**
 * This is BankLog DAO interface
 * @author Conan Zhang
 * @date 2011-10-10
 */
public interface BankLogService extends SpringService {

    int insertBankLog(BankLogDTO dto);
    int deleteBankLog(int id);
    int updateBankLog(BankLogDTO dto);

    BankLogDTO getBankLogById(int id);
    List<BankLogDTO> getBankLogs(Map<String,Object> paramMap);
    PageOutObject<BankLogDTO> getBankLogsPaging(Map<String,Object> paramMap, PageInObject page);
    int getBankLogsCount(Map<String,Object> paramMap);
}

