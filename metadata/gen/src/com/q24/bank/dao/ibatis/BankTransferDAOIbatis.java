//Create by Conan. E-mail:bsspirit@gmail.com
package com.q24.bank.dao.ibatis;

import java.util.List;
import java.util.Map;
import org.conan.common.dao.ibatis.BaseIbatisDAO;
import org.conan.common.model.PageInObject;
import org.conan.common.model.PageOutObject;

import com.q24.bank.dao.BankTransferDAO;
import com.q24.bank.model.BankTransferDTO;

/**
 * This is BankTransfer DAO implemention
 * @spring.bean id="bankTransferDAO"
 * @spring.property name="dataSource" ref="dataSource"
 * @spring.property name="sqlMapClient" ref="sqlMapClient"
 * @author Conan Zhang
 * @date 2011-09-26
 */
public class BankTransferDAOIbatis extends BaseIbatisDAO implements BankTransferDAO {

    public int insertBankTransfer(BankTransferDTO dto) {
        return (Integer) getSqlMapClientTemplate().insert("bankTransfer.insertBankTransfer", dto);
    }

    public int deleteBankTransfer(int id) {
        return getSqlMapClientTemplate().delete("bankTransfer.deleteBankTransfer", id);
    }

    public int updateBankTransfer(BankTransferDTO dto) {
        return getSqlMapClientTemplate().update("bankTransfer.updateBankTransfer", dto);
    }

    public BankTransferDTO getBankTransferById(int id) {
        return (BankTransferDTO) getSqlMapClientTemplate().queryForObject("bankTransfer.getBankTransferById", id);
    }

    public List<BankTransferDTO> getBankTransfers(Map paramMap) {
        return getSqlMapClientTemplate().queryForList("bankTransfer.getBankTransfers", paramMap);
    }

    public PageOutObject<BankTransferDTO> getBankTransfersPaging(Map paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<BankTransferDTO> list = getSqlMapClientTemplate().queryForList("bankTransfer.getBankTransfers", paramMap);
        int count = (Integer) getSqlMapClientTemplate().queryForObject("bankTransfer.getBankTransfersCount", paramMap);
        return new PageOutObject(count, list, page);
    }

}
