//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.dm.quiz.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import org.conan.dm.quiz.model.QuizDTO;

/**
 * This is Quiz DAO interface
 * @author Conan Zhang
 * @date 2012-07-27
 */
public interface QuizDAO extends MybatisDAO {

    int insertQuiz(QuizDTO dto);
    int updateQuiz(QuizDTO dto);
    int deleteQuiz(int id);
    int deleteQuizs (QuizDTO dto);

    QuizDTO getQuizById(int id);
    QuizDTO getQuizOne(Map<String,Object> paramMap);
    List<QuizDTO> getQuizs(Map<String,Object> paramMap);
    int getQuizsCount(Map<String,Object> paramMap);
}

