//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.dm.quiz.web.form;

import org.conan.dm.quiz.model.QuizSubmitDTO;

/**
 * This is QuizSubmitForm Form Model
 * @author Conan Zhang
 * @date 2012-07-27
 */
public class QuizSubmitForm extends QuizSubmitDTO {

private static final long serialVersionUID = 13433808128121L;

public QuizSubmitForm(){}
public QuizSubmitForm(QuizSubmitDTO dto){
super.setId(dto.getId());
super.setQid(dto.getQid());
super.setLang(dto.getLang());
super.setCode(dto.getCode());
super.setCreate_date(dto.getCreate_date());
super.setUid(dto.getUid());
super.setStatus(dto.getStatus());
super.setResult(dto.getResult());
}


}
