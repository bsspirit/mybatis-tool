//Create by Conan. E-mail:bsspirit@gmail.com
package com.q24.bank.model;

import java.sql.Timestamp;
import com.q24.base.BaseObject;

/**
 * This is Bank Model DTO
 * @author Conan Zhang
 * @date 2011-09-26
 */
public class BankDTO extends BaseObject {

private static final long serialVersionUID = 13170301130892L;

public BankDTO(){}
public BankDTO(String bank_name, Timestamp create_date){
this.bank_name = bank_name;
this.create_date = create_date;
}


private int id;
private String bank_name;
private Timestamp create_date;

public int getId() {
return this.id;
}

public String getBank_name (){
return this.bank_name;
}
public Timestamp getCreate_date (){
return this.create_date;
}


public void setId(int id) {
this.id = id;
}

public void setBank_name(String bank_name) {
this.bank_name = bank_name;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
