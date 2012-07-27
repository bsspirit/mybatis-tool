//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package org.conan.dm.quiz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.conan.dm.base.BaseTestCase;
import org.conan.dm.base.service.PageInObject;
import org.conan.dm.base.service.PageOutObject;

import org.conan.dm.quiz.service.QuizService;
import org.conan.dm.quiz.model.QuizDTO;

import static org.junit.Assert.assertEquals;

/**
 * This is Test of Quiz Service implemention
 * @author Conan Zhang
 * @date 2012-07-27
 */
public class QuizServiceImplTest extends BaseTestCase {

    private QuizService quizService;
    private QuizDTO dto;

    public QuizServiceImplTest() {
    }

    @Before
    public void setUp() {
        dto = new QuizDTO();
    }

    @After
    public void tearDown() {
        dto = null;
    }

    @Test
    public void insertQuiz() {
        boolean expected = true;
        int actual = quizService.insertQuiz(dto);
        assertEquals(expected, actual > 1);
    }

    @Test
    public void deleteQuiz() {
        int expected = 1;
        int actual = quizService.deleteQuiz(1);
        assertEquals(expected, actual);
    }

    @Test
    public void updateQuiz() {
        dto.setId(2);

        int expected = 1;
        int actual = quizService.updateQuiz(dto);
        assertEquals(expected, actual);
    }

    @Test
    public void getQuizById() {
        QuizDTO tmp = quizService.getQuizById(1);

        int expected = 1;
        int actual = tmp.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void getQuizs() {
        List<QuizDTO> list = quizService.getQuizs(null);

        int expected = 1;
        int actual = list.get(0).getId();
        assertEquals(expected, actual);
    }

    @Test
    public void getQuizsPaging() {
        Map<String,Object> map = new HashMap<String,Object>();
        PageInObject page = new PageInObject(0, 4, "id", "asc");

        PageOutObject<QuizDTO> pageOut = quizService.getQuizsPaging(map,page);

        int expected = 4;
        int actual = pageOut.getList().size();
        assertEquals(expected, actual);
    }

    @Autowired
    public void setQuizService(QuizService quizService) {
        this.quizService = quizService;
    }
}