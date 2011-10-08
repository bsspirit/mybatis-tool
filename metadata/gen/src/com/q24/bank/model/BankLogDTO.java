//Create by Conan. E-mail:bsspirit@gmail.com
package com.q24.bank.model;

import java.sql.Timestamp;
import com.q24.base.BaseObject;

/**
 * This is BankLog Model DTO
 * @author Conan Zhang
 * @date 2011-09-26
 */
public class BankLogDTO extends BaseObject {

private static final long serialVersionUID = 13170301132070L;

public BankLogDTO(){}
public BankLogDTO(Integer bankid, String tran_ref_no, String code, String description, Timestamp create_date){
this.bankid = bankid;
this.tran_ref_no = tran_ref_no;
this.code = code;
this.description = description;
this.create_date = create_date;
}


private int id;
private Integer bankid;
private String tran_ref_no;
private String code;
private String description;
private Timestamp create_date;

public int getId() {
return this.id;
}

public Integer getBankid (){
return this.bankid;
}
public String getTran_ref_no (){
return this.tran_ref_no;
}
public String getCode (){
return this.code;
}
public String getDescription (){
return this.description;
}
public Timestamp getCreate_date (){
return this.create_date;
}


public void setId(int id) {
this.id = id;
}

public void setBankid(Integer bankid) {
this.bankid = bankid;
}
public void setTran_ref_no(String tran_ref_no) {
this.tran_ref_no = tran_ref_no;
}
public void setCode(String code) {
this.code = code;
}
public void setDescription(String description) {
this.description = description;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
