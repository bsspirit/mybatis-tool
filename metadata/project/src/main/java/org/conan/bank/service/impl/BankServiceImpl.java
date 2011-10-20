//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.bank.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import org.conan.bank.dao.BankDAO;
import org.conan.bank.service.BankService;
import org.conan.bank.model.BankDTO;

/**
 * This is Bank Service implemention
 * @author Conan Zhang
 * @date 2011-10-10
 */
@Service(value="bankService")
public class BankServiceImpl extends SpringServiceImpl implements BankService {

    @Autowired
    BankDAO bankDAO;

    @Override
    public int insertBank(BankDTO dto) {
        return bankDAO.insertBank(dto);
    }

    @Override
    public int deleteBank(int id) {
        return bankDAO.deleteBank(id);
    }

    @Override
    public int updateBank(BankDTO dto) {
        return bankDAO.updateBank(dto);
    }

    @Override
    public BankDTO getBankById(int id) {
        return bankDAO.getBankById(id);
    }

    @Override
    public List<BankDTO> getBanks(Map<String, Object> paramMap) {
        return bankDAO.getBanks(paramMap);
    }

    @Override
    public PageOutObject<BankDTO> getBanksPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<BankDTO> list = bankDAO.getBanks(paramMap);
        int count = bankDAO.getBanksCount(paramMap);
        return new PageOutObject<BankDTO>(count, list, page);
    }
    
    @Override
    public int getBanksCount(Map<String, Object> paramMap) {
        return bankDAO.getBanksCount(paramMap);
    }

}
