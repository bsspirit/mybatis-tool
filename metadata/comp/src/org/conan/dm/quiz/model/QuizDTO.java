//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.dm.quiz.model;

import java.sql.Timestamp;
import java.sql.Timestamp;
import org.conan.base.BaseObject;

/**
 * This is Quiz Model DTO
 * @author Conan Zhang
 * @date 2012-07-27
 */
public class QuizDTO extends BaseObject {

private static final long serialVersionUID = 13433808127920L;

public QuizDTO(){}
public QuizDTO(String title, String content, Timestamp create_date, Timestamp end_date, Integer uid){
this.title = title;
this.content = content;
this.create_date = create_date;
this.end_date = end_date;
this.uid = uid;
}


private int id;
private String title;
private String content;
private Timestamp create_date;
private Timestamp end_date;
private Integer uid;

public int getId() {
return this.id;
}

public String getTitle (){
return this.title;
}
public String getContent (){
return this.content;
}
public Timestamp getCreate_date (){
return this.create_date;
}
public Timestamp getEnd_date (){
return this.end_date;
}
public Integer getUid (){
return this.uid;
}


public void setId(int id) {
this.id = id;
}

public void setTitle(String title) {
this.title = title;
}
public void setContent(String content) {
this.content = content;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}
public void setEnd_date(Timestamp end_date) {
this.end_date = end_date;
}
public void setUid(Integer uid) {
this.uid = uid;
}


}
