//Create by Conan. E-mail:bsspirit@gmail.com
package com.q24.bank.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.conan.common.dao.test.BaseDAOTestCaseJunit44;
import org.conan.common.model.PageInObject;
import org.conan.common.model.PageOutObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.q24.bank.dao.BankLogDAO;
import com.q24.bank.model.BankLogDTO;

import static org.junit.Assert.assertEquals;

/**
 * This is Test of BankLog DAO implemention
 * @author Conan Zhang
 * @date 2011-09-26
 */
public class BankLogDAOIbatisTest extends BaseDAOTestCaseJunit44 {

    private BankLogDAO bankLogDAO;
    private BankLogDTO dto;

    public BankLogDAOIbatisTest() {
    }

    @Before
    public void setUp() {
        dto = new BankLogDTO();
    }

    @After
    public void tearDown() {
        dto = null;
    }

    @Test
    public void insertBankLog() {
        boolean expected = true;
        int actual = bankLogDAO.insertBankLog(dto);
        assertEquals(expected, actual > 1);
    }

    @Test
    public void deleteBankLog() {
        int expected = 1;
        int actual = bankLogDAO.deleteBankLog(1);
        assertEquals(expected, actual);
    }

    @Test
    public void updateBankLog() {
        dto.setId(2);

        int expected = 1;
        int actual = bankLogDAO.updateBankLog(dto);
        assertEquals(expected, actual);
    }

    @Test
    public void getBankLogById() {
        BankLogDTO tmp = bankLogDAO.getBankLogById(1);

        int expected = 1;
        int actual = tmp.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void getBankLogs() {
        List<BankLogDTO> list = bankLogDAO.getBankLogs(null);

        int expected = 1;
        int actual = list.get(0).getId();
        assertEquals(expected, actual);
    }

    @Test
    public void getBankLogsPaging() {
        Map map = new HashMap();
        PageInObject page = new PageInObject(0, 4, "id", "asc");

        PageOutObject<BankLogDTO> pageOut = bankLogDAO.getBankLogsPaging(map,page);

        int expected = 4;
        int actual = pageOut.getList().size();
        assertEquals(expected, actual);
    }

    @Autowired
    public void setBankLogDAO(BankLogDAO bankLogDAO) {
        this.bankLogDAO = bankLogDAO;
    }
}