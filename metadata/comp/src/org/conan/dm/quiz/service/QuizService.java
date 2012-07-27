//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.dm.quiz.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import org.conan.dm.quiz.model.QuizDTO;

/**
 * This is Quiz DAO interface
 * @author Conan Zhang
 * @date 2012-07-27
 */
public interface QuizService extends SpringService {

    int insertQuiz(QuizDTO dto);
    int updateQuiz(QuizDTO dto);
    int saveQuiz(QuizDTO dto);
    int saveQuiz(QuizDTO dto, Map<String,Object> paramMap);
    int deleteQuiz(int id);
    int deleteQuiz(QuizDTO dto);
    

    QuizDTO getQuizById(int id);
    QuizDTO getQuizOne(Map<String,Object> paramMap);
    List<QuizDTO> getQuizs(Map<String,Object> paramMap);
    PageOutObject<QuizDTO> getQuizsPaging(Map<String,Object> paramMap, PageInObject page);
    int getQuizsCount(Map<String,Object> paramMap);
}

