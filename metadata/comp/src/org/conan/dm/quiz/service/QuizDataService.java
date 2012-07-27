//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.dm.quiz.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import org.conan.dm.quiz.model.QuizDataDTO;

/**
 * This is QuizData DAO interface
 * @author Conan Zhang
 * @date 2012-07-27
 */
public interface QuizDataService extends SpringService {

    int insertQuizData(QuizDataDTO dto);
    int updateQuizData(QuizDataDTO dto);
    int saveQuizData(QuizDataDTO dto);
    int saveQuizData(QuizDataDTO dto, Map<String,Object> paramMap);
    int deleteQuizData(int id);
    int deleteQuizData(QuizDataDTO dto);
    

    QuizDataDTO getQuizDataById(int id);
    QuizDataDTO getQuizDataOne(Map<String,Object> paramMap);
    List<QuizDataDTO> getQuizDatas(Map<String,Object> paramMap);
    PageOutObject<QuizDataDTO> getQuizDatasPaging(Map<String,Object> paramMap, PageInObject page);
    int getQuizDatasCount(Map<String,Object> paramMap);
}

