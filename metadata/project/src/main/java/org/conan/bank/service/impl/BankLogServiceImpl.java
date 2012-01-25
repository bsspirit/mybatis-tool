//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.bank.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import org.conan.bank.dao.BankLogDAO;
import org.conan.bank.service.BankLogService;
import org.conan.bank.model.BankLogDTO;

/**
 * This is BankLog Service implemention
 * @author Conan Zhang
 * @date 2011-10-10
 */
@Service(value="bankLogService")
public class BankLogServiceImpl extends SpringServiceImpl implements BankLogService {

    @Autowired
    BankLogDAO bankLogDAO;

    @Override
    public int insertBankLog(BankLogDTO dto) {
        return bankLogDAO.insertBankLog(dto);
    }

    @Override
    public int deleteBankLog(int id) {
        return bankLogDAO.deleteBankLog(id);
    }

    @Override
    public int updateBankLog(BankLogDTO dto) {
        return bankLogDAO.updateBankLog(dto);
    }

    @Override
    public BankLogDTO getBankLogById(int id) {
        return bankLogDAO.getBankLogById(id);
    }

    @Override
    public List<BankLogDTO> getBankLogs(Map<String, Object> paramMap) {
        return bankLogDAO.getBankLogs(paramMap);
    }

    @Override
    public PageOutObject<BankLogDTO> getBankLogsPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<BankLogDTO> list = bankLogDAO.getBankLogs(paramMap);
        int count = bankLogDAO.getBankLogsCount(paramMap);
        return new PageOutObject<BankLogDTO>(count, list, page);
    }
    
    @Override
    public int getBankLogsCount(Map<String, Object> paramMap) {
        return bankLogDAO.getBankLogsCount(paramMap);
    }

}
