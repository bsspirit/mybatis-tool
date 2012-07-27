//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.dm.quiz.web.form;

import org.conan.dm.quiz.model.QuizDTO;

/**
 * This is QuizForm Form Model
 * @author Conan Zhang
 * @date 2012-07-27
 */
public class QuizForm extends QuizDTO {

private static final long serialVersionUID = 13433808128062L;

public QuizForm(){}
public QuizForm(QuizDTO dto){
super.setId(dto.getId());
super.setTitle(dto.getTitle());
super.setContent(dto.getContent());
super.setCreate_date(dto.getCreate_date());
super.setEnd_date(dto.getEnd_date());
super.setUid(dto.getUid());
}


}
