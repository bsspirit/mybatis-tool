//Create by Conan. E-mail:bsspirit@gmail.com
package com.q24.bank.web;

import com.q24.bank.model.BankTransferDTO;

/**
 * This is BankTransferForm Form Model
 * @author Conan Zhang
 * @date 2011-09-26
 */
public class BankTransferForm extends BankTransferDTO {

public BankTransferForm(){}
public BankTransferForm(BankTransferDTO dto){
super.setId(dto.getId());
super.setBankid(dto.getBankid());
super.setTran_date(dto.getTran_date());
super.setTran_time(dto.getTran_time());
super.setTran_flag(dto.getTran_flag());
super.setTran_msg(dto.getTran_msg());
super.setTaocan_flag(dto.getTaocan_flag());
super.setTaocan_type(dto.getTaocan_type());
super.setTran_fee(dto.getTran_fee());
super.setP_flowno(dto.getP_flowno());
super.setTran_ref_no(dto.getTran_ref_no());
}


}
