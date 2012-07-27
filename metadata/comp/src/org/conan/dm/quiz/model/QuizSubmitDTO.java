//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.dm.quiz.model;

import java.sql.Timestamp;
import org.conan.base.BaseObject;

/**
 * This is QuizSubmit Model DTO
 * @author Conan Zhang
 * @date 2012-07-27
 */
public class QuizSubmitDTO extends BaseObject {

private static final long serialVersionUID = 13433808128021L;

public QuizSubmitDTO(){}
public QuizSubmitDTO(Integer qid, String lang, String code, Timestamp create_date, Integer uid, Integer status, Integer result){
this.qid = qid;
this.lang = lang;
this.code = code;
this.create_date = create_date;
this.uid = uid;
this.status = status;
this.result = result;
}


private int id;
private Integer qid;
private String lang;
private String code;
private Timestamp create_date;
private Integer uid;
private Integer status;
private Integer result;

public int getId() {
return this.id;
}

public Integer getQid (){
return this.qid;
}
public String getLang (){
return this.lang;
}
public String getCode (){
return this.code;
}
public Timestamp getCreate_date (){
return this.create_date;
}
public Integer getUid (){
return this.uid;
}
public Integer getStatus (){
return this.status;
}
public Integer getResult (){
return this.result;
}


public void setId(int id) {
this.id = id;
}

public void setQid(Integer qid) {
this.qid = qid;
}
public void setLang(String lang) {
this.lang = lang;
}
public void setCode(String code) {
this.code = code;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}
public void setUid(Integer uid) {
this.uid = uid;
}
public void setStatus(Integer status) {
this.status = status;
}
public void setResult(Integer result) {
this.result = result;
}


}
