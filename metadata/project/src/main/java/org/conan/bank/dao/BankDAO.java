//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.bank.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import org.conan.bank.model.BankDTO;

/**
 * This is Bank DAO interface
 * @author Conan Zhang
 * @date 2011-10-10
 */
public interface BankDAO extends MybatisDAO {

    int insertBank(BankDTO dto);
    int deleteBank(int id);
    int updateBank(BankDTO dto);

    BankDTO getBankById(int id);
    List<BankDTO> getBanks(Map<String,Object> paramMap);
    int getBanksCount(Map<String,Object> paramMap);
}

