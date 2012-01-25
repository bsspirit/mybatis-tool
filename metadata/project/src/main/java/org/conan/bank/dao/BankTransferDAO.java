//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.bank.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import org.conan.bank.model.BankTransferDTO;

/**
 * This is BankTransfer DAO interface
 * @author Conan Zhang
 * @date 2011-10-10
 */
public interface BankTransferDAO extends MybatisDAO {

    int insertBankTransfer(BankTransferDTO dto);
    int deleteBankTransfer(int id);
    int updateBankTransfer(BankTransferDTO dto);

    BankTransferDTO getBankTransferById(int id);
    List<BankTransferDTO> getBankTransfers(Map<String,Object> paramMap);
    int getBankTransfersCount(Map<String,Object> paramMap);
}

