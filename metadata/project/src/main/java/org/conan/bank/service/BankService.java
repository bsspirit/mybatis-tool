//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.bank.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import org.conan.bank.model.BankDTO;

/**
 * This is Bank DAO interface
 * @author Conan Zhang
 * @date 2011-10-10
 */
public interface BankService extends SpringService {

    int insertBank(BankDTO dto);
    int deleteBank(int id);
    int updateBank(BankDTO dto);

    BankDTO getBankById(int id);
    List<BankDTO> getBanks(Map<String,Object> paramMap);
    PageOutObject<BankDTO> getBanksPaging(Map<String,Object> paramMap, PageInObject page);
    int getBanksCount(Map<String,Object> paramMap);
}

