//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.dm.quiz.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import org.conan.dm.quiz.dao.QuizDAO;
import org.conan.dm.quiz.service.QuizService;
import org.conan.dm.quiz.model.QuizDTO;

/**
 * This is Quiz Service implemention
 * @author Conan Zhang
 * @date 2012-07-27
 */
@Service(value="quizService")
public class QuizServiceImpl extends SpringServiceImpl implements QuizService {

    @Autowired
    QuizDAO quizDAO;

    public int insertQuiz(QuizDTO dto) {
        return quizDAO.insertQuiz(dto);
    }
    
    public int updateQuiz(QuizDTO dto) {
        return quizDAO.updateQuiz(dto);
    }
    
    public int saveQuiz(QuizDTO dto) {
        if (dto.getId() > 0) {
            return updateQuiz(dto);
        }
        return insertQuiz(dto);
    }

    public int saveQuiz(QuizDTO dto, Map<String, Object> paramMap) {
        QuizDTO obj = getQuizOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateQuiz(dto);
        }
         return insertQuiz(dto);
    }

    public int deleteQuiz(int id) {
        return quizDAO.deleteQuiz(id);
    }

	public int deleteQuiz(QuizDTO dto) {
        return quizDAO.deleteQuizs(dto);
    }

    public QuizDTO getQuizById(int id) {
        return quizDAO.getQuizById(id);
    }
    
    public QuizDTO getQuizOne(Map<String, Object> paramMap) {
        return quizDAO.getQuizOne(paramMap);
    }

    public List<QuizDTO> getQuizs(Map<String, Object> paramMap) {
        return quizDAO.getQuizs(paramMap);
    }

    public PageOutObject<QuizDTO> getQuizsPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<QuizDTO> list = quizDAO.getQuizs(paramMap);
        int count = quizDAO.getQuizsCount(paramMap);
        return new PageOutObject<QuizDTO>(count, list, page);
    }
    
    public int getQuizsCount(Map<String, Object> paramMap) {
        return quizDAO.getQuizsCount(paramMap);
    }

}
