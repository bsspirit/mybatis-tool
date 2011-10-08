//Create by Conan. E-mail:bsspirit@gmail.com
package com.q24.bank.web;

import com.q24.bank.model.BankDTO;

/**
 * This is BankForm Form Model
 * @author Conan Zhang
 * @date 2011-09-26
 */
public class BankForm extends BankDTO {

public BankForm(){}
public BankForm(BankDTO dto){
super.setId(dto.getId());
super.setBank_name(dto.getBank_name());
super.setCreate_date(dto.getCreate_date());
}


}
