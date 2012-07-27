//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.dm.quiz.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import org.conan.dm.quiz.dao.QuizSubmitDAO;
import org.conan.dm.quiz.service.QuizSubmitService;
import org.conan.dm.quiz.model.QuizSubmitDTO;

/**
 * This is QuizSubmit Service implemention
 * @author Conan Zhang
 * @date 2012-07-27
 */
@Service(value="quizSubmitService")
public class QuizSubmitServiceImpl extends SpringServiceImpl implements QuizSubmitService {

    @Autowired
    QuizSubmitDAO quizSubmitDAO;

    public int insertQuizSubmit(QuizSubmitDTO dto) {
        return quizSubmitDAO.insertQuizSubmit(dto);
    }
    
    public int updateQuizSubmit(QuizSubmitDTO dto) {
        return quizSubmitDAO.updateQuizSubmit(dto);
    }
    
    public int saveQuizSubmit(QuizSubmitDTO dto) {
        if (dto.getId() > 0) {
            return updateQuizSubmit(dto);
        }
        return insertQuizSubmit(dto);
    }

    public int saveQuizSubmit(QuizSubmitDTO dto, Map<String, Object> paramMap) {
        QuizSubmitDTO obj = getQuizSubmitOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateQuizSubmit(dto);
        }
         return insertQuizSubmit(dto);
    }

    public int deleteQuizSubmit(int id) {
        return quizSubmitDAO.deleteQuizSubmit(id);
    }

	public int deleteQuizSubmit(QuizSubmitDTO dto) {
        return quizSubmitDAO.deleteQuizSubmits(dto);
    }

    public QuizSubmitDTO getQuizSubmitById(int id) {
        return quizSubmitDAO.getQuizSubmitById(id);
    }
    
    public QuizSubmitDTO getQuizSubmitOne(Map<String, Object> paramMap) {
        return quizSubmitDAO.getQuizSubmitOne(paramMap);
    }

    public List<QuizSubmitDTO> getQuizSubmits(Map<String, Object> paramMap) {
        return quizSubmitDAO.getQuizSubmits(paramMap);
    }

    public PageOutObject<QuizSubmitDTO> getQuizSubmitsPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<QuizSubmitDTO> list = quizSubmitDAO.getQuizSubmits(paramMap);
        int count = quizSubmitDAO.getQuizSubmitsCount(paramMap);
        return new PageOutObject<QuizSubmitDTO>(count, list, page);
    }
    
    public int getQuizSubmitsCount(Map<String, Object> paramMap) {
        return quizSubmitDAO.getQuizSubmitsCount(paramMap);
    }

}
