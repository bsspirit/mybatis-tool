//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.bank.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.conan.base.BaseTestCase;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import org.conan.bank.service.BankService;
import org.conan.bank.model.BankDTO;

import static org.junit.Assert.assertEquals;

/**
 * This is Test of Bank Service implemention
 * @author Conan Zhang
 * @date 2011-10-18
 */
public class BankServiceImplTest extends BaseTestCase {

    private BankService bankService;
    private BankDTO dto;

    public BankServiceImplTest() {
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
        int actual = bankService.insertBank(dto);
        assertEquals(expected, actual > 1);
    }

    @Test
    public void deleteBank() {
        int expected = 1;
        int actual = bankService.deleteBank(1);
        assertEquals(expected, actual);
    }

    @Test
    public void updateBank() {
        dto.setId(2);

        int expected = 1;
        int actual = bankService.updateBank(dto);
        assertEquals(expected, actual);
    }

    @Test
    public void getBankById() {
        BankDTO tmp = bankService.getBankById(1);

        int expected = 1;
        int actual = tmp.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void getBanks() {
        List<BankDTO> list = bankService.getBanks(null);

        int expected = 1;
        int actual = list.get(0).getId();
        assertEquals(expected, actual);
    }

    @Test
    public void getBanksPaging() {
        Map<String,Object> map = new HashMap<String,Object>();
        PageInObject page = new PageInObject(0, 4, "id", "asc");

        PageOutObject<BankDTO> pageOut = bankService.getBanksPaging(map,page);

        int expected = 4;
        int actual = pageOut.getList().size();
        assertEquals(expected, actual);
    }

    @Autowired
    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }
}