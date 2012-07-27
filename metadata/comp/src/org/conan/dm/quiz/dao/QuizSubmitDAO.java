//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.dm.quiz.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import org.conan.dm.quiz.model.QuizSubmitDTO;

/**
 * This is QuizSubmit DAO interface
 * @author Conan Zhang
 * @date 2012-07-27
 */
public interface QuizSubmitDAO extends MybatisDAO {

    int insertQuizSubmit(QuizSubmitDTO dto);
    int updateQuizSubmit(QuizSubmitDTO dto);
    int deleteQuizSubmit(int id);
    int deleteQuizSubmits (QuizSubmitDTO dto);

    QuizSubmitDTO getQuizSubmitById(int id);
    QuizSubmitDTO getQuizSubmitOne(Map<String,Object> paramMap);
    List<QuizSubmitDTO> getQuizSubmits(Map<String,Object> paramMap);
    int getQuizSubmitsCount(Map<String,Object> paramMap);
}

