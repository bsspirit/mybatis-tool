//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.dm.quiz.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import org.conan.dm.quiz.dao.QuizDataDAO;
import org.conan.dm.quiz.service.QuizDataService;
import org.conan.dm.quiz.model.QuizDataDTO;

/**
 * This is QuizData Service implemention
 * @author Conan Zhang
 * @date 2012-07-27
 */
@Service(value="quizDataService")
public class QuizDataServiceImpl extends SpringServiceImpl implements QuizDataService {

    @Autowired
    QuizDataDAO quizDataDAO;

    public int insertQuizData(QuizDataDTO dto) {
        return quizDataDAO.insertQuizData(dto);
    }
    
    public int updateQuizData(QuizDataDTO dto) {
        return quizDataDAO.updateQuizData(dto);
    }
    
    public int saveQuizData(QuizDataDTO dto) {
        if (dto.getId() > 0) {
            return updateQuizData(dto);
        }
        return insertQuizData(dto);
    }

    public int saveQuizData(QuizDataDTO dto, Map<String, Object> paramMap) {
        QuizDataDTO obj = getQuizDataOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateQuizData(dto);
        }
         return insertQuizData(dto);
    }

    public int deleteQuizData(int id) {
        return quizDataDAO.deleteQuizData(id);
    }

	public int deleteQuizData(QuizDataDTO dto) {
        return quizDataDAO.deleteQuizDatas(dto);
    }

    public QuizDataDTO getQuizDataById(int id) {
        return quizDataDAO.getQuizDataById(id);
    }
    
    public QuizDataDTO getQuizDataOne(Map<String, Object> paramMap) {
        return quizDataDAO.getQuizDataOne(paramMap);
    }

    public List<QuizDataDTO> getQuizDatas(Map<String, Object> paramMap) {
        return quizDataDAO.getQuizDatas(paramMap);
    }

    public PageOutObject<QuizDataDTO> getQuizDatasPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<QuizDataDTO> list = quizDataDAO.getQuizDatas(paramMap);
        int count = quizDataDAO.getQuizDatasCount(paramMap);
        return new PageOutObject<QuizDataDTO>(count, list, page);
    }
    
    public int getQuizDatasCount(Map<String, Object> paramMap) {
        return quizDataDAO.getQuizDatasCount(paramMap);
    }

}
