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

import com.q24.bank.dao.BankDAO;
import com.q24.bank.model.BankDTO;

import static org.junit.Assert.assertEquals;

/**
 * This is Test of Bank DAO implemention
 * @author Conan Zhang
 * @date 2011-09-26
 */
public class BankDAOIbatisTest extends BaseDAOTestCaseJunit44 {

    private BankDAO bankDAO;
    private BankDTO dto;

    public BankDAOIbatisTest() {
    }

    @Before
    public void setUp() {
        dto = new BankDTO();
    }

    @After
    public void tearDown() {
        dto = null;
    }

    @Test
    public void insertBank() {
        boolean expected = true;
        int actual = bankDAO.insertBank(dto);
        assertEquals(expected, actual > 1);
    }

    @Test
    public void deleteBank() {
        int expected = 1;
        int actual = bankDAO.deleteBank(1);
        assertEquals(expected, actual);
    }

    @Test
    public void updateBank() {
        dto.setId(2);

        int expected = 1;
        int actual = bankDAO.updateBank(dto);
        assertEquals(expected, actual);
    }

    @Test
    public void getBankById() {
        BankDTO tmp = bankDAO.getBankById(1);

        int expected = 1;
        int actual = tmp.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void getBanks() {
        List<BankDTO> list = bankDAO.getBanks(null);

        int expected = 1;
        int actual = list.get(0).getId();
        assertEquals(expected, actual);
    }

    @Test
    public void getBanksPaging() {
        Map map = new HashMap();
        PageInObject page = new PageInObject(0, 4, "id", "asc");

        PageOutObject<BankDTO> pageOut = bankDAO.getBanksPaging(map,page);

        int expected = 4;
        int actual = pageOut.getList().size();
        assertEquals(expected, actual);
    }

    @Autowired
    public void setBankDAO(BankDAO bankDAO) {
        this.bankDAO = bankDAO;
    }
}