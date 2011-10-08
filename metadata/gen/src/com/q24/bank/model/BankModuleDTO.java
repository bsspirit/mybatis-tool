//Create by Conan. E-mail:bsspirit@gmail.com
package com.q24.bank.model;

import com.q24.base.BaseObject;

/**
 * This is BankModule Model DTO
 * @author Conan Zhang
 * @date 2011-09-26
 */
public class BankModuleDTO extends BaseObject {

private static final long serialVersionUID = ${timestamp};

public BankModuleDTO(){}
public BankModuleDTO(BankDTO bankDTO, BankLogDTO bankLogDTO, BankTransferDTO bankTransferDTO){
this.bankDTO = bankDTO;
this.bankLogDTO = bankLogDTO;
this.bankTransferDTO = bankTransferDTO;
}


private int id;
private BankDTO bankDTO;
private BankLogDTO bankLogDTO;
private BankTransferDTO bankTransferDTO;

public int getId() {
return this.id;
}

public BankDTO getBankDTO (){
return this.bankDTO;
}
public BankLogDTO getBankLogDTO (){
return this.bankLogDTO;
}
public BankTransferDTO getBankTransferDTO (){
return this.bankTransferDTO;
}


public void setId(int id) {
this.id = id;
}

public void setBankDTO(BankDTO bankDTO) {
this.bankDTO = bankDTO;
}
public void setBankLogDTO(BankLogDTO bankLogDTO) {
this.bankLogDTO = bankLogDTO;
}
public void setBankTransferDTO(BankTransferDTO bankTransferDTO) {
this.bankTransferDTO = bankTransferDTO;
}


}
