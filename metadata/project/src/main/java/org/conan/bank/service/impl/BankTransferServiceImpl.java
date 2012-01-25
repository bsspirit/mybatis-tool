//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.bank.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import org.conan.bank.dao.BankTransferDAO;
import org.conan.bank.service.BankTransferService;
import org.conan.bank.model.BankTransferDTO;

/**
 * This is BankTransfer Service implemention
 * @author Conan Zhang
 * @date 2011-10-10
 */
@Service(value="bankTransferService")
public class BankTransferServiceImpl extends SpringServiceImpl implements BankTransferService {

    @Autowired
    BankTransferDAO bankTransferDAO;

    @Override
    public int insertBankTransfer(BankTransferDTO dto) {
        return bankTransferDAO.insertBankTransfer(dto);
    }

    @Override
    public int deleteBankTransfer(int id) {
        return bankTransferDAO.deleteBankTransfer(id);
    }

    @Override
    public int updateBankTransfer(BankTransferDTO dto) {
        return bankTransferDAO.updateBankTransfer(dto);
    }

    @Override
    public BankTransferDTO getBankTransferById(int id) {
        return bankTransferDAO.getBankTransferById(id);
    }

    @Override
    public List<BankTransferDTO> getBankTransfers(Map<String, Object> paramMap) {
        return bankTransferDAO.getBankTransfers(paramMap);
    }

    @Override
    public PageOutObject<BankTransferDTO> getBankTransfersPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<BankTransferDTO> list = bankTransferDAO.getBankTransfers(paramMap);
        int count = bankTransferDAO.getBankTransfersCount(paramMap);
        return new PageOutObject<BankTransferDTO>(count, list, page);
    }
    
    @Override
    public int getBankTransfersCount(Map<String, Object> paramMap) {
        return bankTransferDAO.getBankTransfersCount(paramMap);
    }

}
