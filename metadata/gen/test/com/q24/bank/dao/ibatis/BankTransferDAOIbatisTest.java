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

import com.q24.bank.dao.BankTransferDAO;
import com.q24.bank.model.BankTransferDTO;

import static org.junit.Assert.assertEquals;

/**
 * This is Test of BankTransfer DAO implemention
 * @author Conan Zhang
 * @date 2011-09-26
 */
public class BankTransferDAOIbatisTest extends BaseDAOTestCaseJunit44 {

    private BankTransferDAO bankTransferDAO;
    private BankTransferDTO dto;

    public BankTransferDAOIbatisTest() {
    }

    @Before
    public void setUp() {
        dto = new BankTransferDTO();
    }

    @After
    public void tearDown() {
        dto = null;
    }

    @Test
    public void insertBankTransfer() {
        boolean expected = true;
        int actual = bankTransferDAO.insertBankTransfer(dto);
        assertEquals(expected, actual > 1);
    }

    @Test
    public void deleteBankTransfer() {
        int expected = 1;
        int actual = bankTransferDAO.deleteBankTransfer(1);
        assertEquals(expected, actual);
    }

    @Test
    public void updateBankTransfer() {
        dto.setId(2);

        int expected = 1;
        int actual = bankTransferDAO.updateBankTransfer(dto);
        assertEquals(expected, actual);
    }

    @Test
    public void getBankTransferById() {
        BankTransferDTO tmp = bankTransferDAO.getBankTransferById(1);

        int expected = 1;
        int actual = tmp.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void getBankTransfers() {
        List<BankTransferDTO> list = bankTransferDAO.getBankTransfers(null);

        int expected = 1;
        int actual = list.get(0).getId();
        assertEquals(expected, actual);
    }

    @Test
    public void getBankTransfersPaging() {
        Map map = new HashMap();
        PageInObject page = new PageInObject(0, 4, "id", "asc");

        PageOutObject<BankTransferDTO> pageOut = bankTransferDAO.getBankTransfersPaging(map,page);

        int expected = 4;
        int actual = pageOut.getList().size();
        assertEquals(expected, actual);
    }

    @Autowired
    public void setBankTransferDAO(BankTransferDAO bankTransferDAO) {
        this.bankTransferDAO = bankTransferDAO;
    }
}