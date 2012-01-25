//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.bank.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.conan.bank.model.BankLogDTO;
import org.conan.bank.service.BankLogService;
import org.conan.base.BaseTestCase;

/**
 * This is BankLog Service Test
 * @author Conan Zhang
 * @date 2011-10-10
 */
public class BankLogServiceImplTest extends BaseTestCase {

    @Autowired
    BankLogService bankLogService;

    @Test
    public void saveBankLog() {
        BankLogDTO dto = new BankLogDTO();
        dto.setBankid(212121);
        dto.setCode("000000");
        dto.setDescription("test");
        bankLogService.insertBankLog(dto);
    }

}
