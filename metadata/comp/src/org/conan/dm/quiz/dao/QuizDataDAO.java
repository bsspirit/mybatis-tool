//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.dm.quiz.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import org.conan.dm.quiz.model.QuizDataDTO;

/**
 * This is QuizData DAO interface
 * @author Conan Zhang
 * @date 2012-07-27
 */
public interface QuizDataDAO extends MybatisDAO {

    int insertQuizData(QuizDataDTO dto);
    int updateQuizData(QuizDataDTO dto);
    int deleteQuizData(int id);
    int deleteQuizDatas (QuizDataDTO dto);

    QuizDataDTO getQuizDataById(int id);
    QuizDataDTO getQuizDataOne(Map<String,Object> paramMap);
    List<QuizDataDTO> getQuizDatas(Map<String,Object> paramMap);
    int getQuizDatasCount(Map<String,Object> paramMap);
}

