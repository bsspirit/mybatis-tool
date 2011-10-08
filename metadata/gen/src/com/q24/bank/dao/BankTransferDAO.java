//Create by Conan. E-mail:bsspirit@gmail.com
package com.q24.bank.dao;

import java.util.List;
import java.util.Map;
import com.q24.base.dao.MybatisDAO;
import com.q24.base.dao.PageInObject;
import com.q24.base.dao.PageOutObject;

import com.q24.bank.model.BankTransferDTO;

/**
 * This is BankTransfer DAO interface
 * @author Conan Zhang
 * @date 2011-09-26
 */
public interface BankTransferDAO extends MybatisDAO {

    int insertBankTransfer(BankTransferDTO dto);
    int deleteBankTransfer(int id);
    int updateBankTransfer(BankTransferDTO dto);

    BankTransferDTO getBankTransferById(int id);
    List<BankTransferDTO> getBankTransfers(Map<String,Object> paramMap);
    PageOutObject<BankTransferDTO> getBankTransfersPaging(Map<String,Object> paramMap, PageInObject page);
    int getBankTransfersCount(Map<String,Object> paramMap);
}

