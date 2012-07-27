//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.dm.quiz.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import org.conan.dm.quiz.model.QuizSubmitDTO;

/**
 * This is QuizSubmit DAO interface
 * @author Conan Zhang
 * @date 2012-07-27
 */
public interface QuizSubmitService extends SpringService {

    int insertQuizSubmit(QuizSubmitDTO dto);
    int updateQuizSubmit(QuizSubmitDTO dto);
    int saveQuizSubmit(QuizSubmitDTO dto);
    int saveQuizSubmit(QuizSubmitDTO dto, Map<String,Object> paramMap);
    int deleteQuizSubmit(int id);
    int deleteQuizSubmit(QuizSubmitDTO dto);
    

    QuizSubmitDTO getQuizSubmitById(int id);
    QuizSubmitDTO getQuizSubmitOne(Map<String,Object> paramMap);
    List<QuizSubmitDTO> getQuizSubmits(Map<String,Object> paramMap);
    PageOutObject<QuizSubmitDTO> getQuizSubmitsPaging(Map<String,Object> paramMap, PageInObject page);
    int getQuizSubmitsCount(Map<String,Object> paramMap);
}

