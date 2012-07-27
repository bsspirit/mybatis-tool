//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.dm.quiz.web.form;

import org.conan.dm.quiz.model.QuizDataDTO;

/**
 * This is QuizDataForm Form Model
 * @author Conan Zhang
 * @date 2012-07-27
 */
public class QuizDataForm extends QuizDataDTO {

private static final long serialVersionUID = 13433808128092L;

public QuizDataForm(){}
public QuizDataForm(QuizDataDTO dto){
super.setId(dto.getId());
super.setQid(dto.getQid());
super.setType(dto.getType());
super.setFile(dto.getFile());
super.setLocal(dto.getLocal());
super.setCreate_date(dto.getCreate_date());
}


}
