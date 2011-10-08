//Create by Conan. E-mail:bsspirit@gmail.com
package com.q24.bank.model;

import com.q24.base.BaseObject;

/**
 * This is BankTransfer Model DTO
 * @author Conan Zhang
 * @date 2011-09-26
 */
public class BankTransferDTO extends BaseObject {

private static final long serialVersionUID = 13170301132120L;

public BankTransferDTO(){}
public BankTransferDTO(Integer bankid, String tran_date, String tran_time, String tran_flag, String tran_msg, String taocan_flag, String taocan_type, String tran_fee, String p_flowno, String tran_ref_no){
this.bankid = bankid;
this.tran_date = tran_date;
this.tran_time = tran_time;
this.tran_flag = tran_flag;
this.tran_msg = tran_msg;
this.taocan_flag = taocan_flag;
this.taocan_type = taocan_type;
this.tran_fee = tran_fee;
this.p_flowno = p_flowno;
this.tran_ref_no = tran_ref_no;
}


private int id;
private Integer bankid;
private String tran_date;
private String tran_time;
private String tran_flag;
private String tran_msg;
private String taocan_flag;
private String taocan_type;
private String tran_fee;
private String p_flowno;
private String tran_ref_no;

public int getId() {
return this.id;
}

public Integer getBankid (){
return this.bankid;
}
public String getTran_date (){
return this.tran_date;
}
public String getTran_time (){
return this.tran_time;
}
public String getTran_flag (){
return this.tran_flag;
}
public String getTran_msg (){
return this.tran_msg;
}
public String getTaocan_flag (){
return this.taocan_flag;
}
public String getTaocan_type (){
return this.taocan_type;
}
public String getTran_fee (){
return this.tran_fee;
}
public String getP_flowno (){
return this.p_flowno;
}
public String getTran_ref_no (){
return this.tran_ref_no;
}


public void setId(int id) {
this.id = id;
}

public void setBankid(Integer bankid) {
this.bankid = bankid;
}
public void setTran_date(String tran_date) {
this.tran_date = tran_date;
}
public void setTran_time(String tran_time) {
this.tran_time = tran_time;
}
public void setTran_flag(String tran_flag) {
this.tran_flag = tran_flag;
}
public void setTran_msg(String tran_msg) {
this.tran_msg = tran_msg;
}
public void setTaocan_flag(String taocan_flag) {
this.taocan_flag = taocan_flag;
}
public void setTaocan_type(String taocan_type) {
this.taocan_type = taocan_type;
}
public void setTran_fee(String tran_fee) {
this.tran_fee = tran_fee;
}
public void setP_flowno(String p_flowno) {
this.p_flowno = p_flowno;
}
public void setTran_ref_no(String tran_ref_no) {
this.tran_ref_no = tran_ref_no;
}


}
