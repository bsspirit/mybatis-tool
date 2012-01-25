//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.bank.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import org.conan.bank.model.BankTransferDTO;

/**
 * This is BankTransfer DAO interface
 * @author Conan Zhang
 * @date 2011-10-10
 */
public interface BankTransferService extends SpringService {

    int insertBankTransfer(BankTransferDTO dto);
    int deleteBankTransfer(int id);
    int updateBankTransfer(BankTransferDTO dto);

    BankTransferDTO getBankTransferById(int id);
    List<BankTransferDTO> getBankTransfers(Map<String,Object> paramMap);
    PageOutObject<BankTransferDTO> getBankTransfersPaging(Map<String,Object> paramMap, PageInObject page);
    int getBankTransfersCount(Map<String,Object> paramMap);
}

