//Create by Conan. E-mail:bsspirit@gmail.com
package com.q24.bea.web;

import com.q24.bea.model.BankLogDTO;

/**
 * This is BankLogForm Form Model
 * @author Conan Zhang
 * @date 2011-09-22
 */
public class BankLogForm extends BankLogDTO {

public BankLogForm(){}
public BankLogForm(BankLogDTO dto){
super.setId(dto.getId());
super.setBankid(dto.getBankid());
super.setTran_ref_no(dto.getTran_ref_no());
super.setCode(dto.getCode());
super.setDescription(dto.getDescription());
super.setCreate_date(dto.getCreate_date());
}


}
