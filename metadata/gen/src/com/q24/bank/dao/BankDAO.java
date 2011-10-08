//Create by Conan. E-mail:bsspirit@gmail.com
package com.q24.bank.dao;

import java.util.List;
import java.util.Map;
import com.q24.base.dao.MybatisDAO;
import com.q24.base.dao.PageInObject;
import com.q24.base.dao.PageOutObject;

import com.q24.bank.model.BankDTO;

/**
 * This is Bank DAO interface
 * @author Conan Zhang
 * @date 2011-09-26
 */
public interface BankDAO extends MybatisDAO {

    int insertBank(BankDTO dto);
    int deleteBank(int id);
    int updateBank(BankDTO dto);

    BankDTO getBankById(int id);
    List<BankDTO> getBanks(Map<String,Object> paramMap);
    PageOutObject<BankDTO> getBanksPaging(Map<String,Object> paramMap, PageInObject page);
    int getBanksCount(Map<String,Object> paramMap);
}

