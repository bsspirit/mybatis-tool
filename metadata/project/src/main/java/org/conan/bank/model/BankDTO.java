//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.bank.model;

import java.sql.Timestamp;
import org.conan.base.BaseObject;

/**
 * This is Bank Model DTO
 * @author Conan Zhang
 * @date 2011-10-10
 */
public class BankDTO extends BaseObject {

private static final long serialVersionUID = 13182325212810L;

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
