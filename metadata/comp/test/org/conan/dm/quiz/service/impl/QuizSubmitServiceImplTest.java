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

import org.conan.dm.quiz.service.QuizSubmitService;
import org.conan.dm.quiz.model.QuizSubmitDTO;

import static org.junit.Assert.assertEquals;

/**
 * This is Test of QuizSubmit Service implemention
 * @author Conan Zhang
 * @date 2012-07-27
 */
public class QuizSubmitServiceImplTest extends BaseTestCase {

    private QuizSubmitService quizSubmitService;
    private QuizSubmitDTO dto;

    public QuizSubmitServiceImplTest() {
    }

    @Before
    public void setUp() {
        dto = new QuizSubmitDTO();
    }

    @After
    public void tearDown() {
        dto = null;
    }

    @Test
    public void insertQuizSubmit() {
        boolean expected = true;
        int actual = quizSubmitService.insertQuizSubmit(dto);
        assertEquals(expected, actual > 1);
    }

    @Test
    public void deleteQuizSubmit() {
        int expected = 1;
        int actual = quizSubmitService.deleteQuizSubmit(1);
        assertEquals(expected, actual);
    }

    @Test
    public void updateQuizSubmit() {
        dto.setId(2);

        int expected = 1;
        int actual = quizSubmitService.updateQuizSubmit(dto);
        assertEquals(expected, actual);
    }

    @Test
    public void getQuizSubmitById() {
        QuizSubmitDTO tmp = quizSubmitService.getQuizSubmitById(1);

        int expected = 1;
        int actual = tmp.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void getQuizSubmits() {
        List<QuizSubmitDTO> list = quizSubmitService.getQuizSubmits(null);

        int expected = 1;
        int actual = list.get(0).getId();
        assertEquals(expected, actual);
    }

    @Test
    public void getQuizSubmitsPaging() {
        Map<String,Object> map = new HashMap<String,Object>();
        PageInObject page = new PageInObject(0, 4, "id", "asc");

        PageOutObject<QuizSubmitDTO> pageOut = quizSubmitService.getQuizSubmitsPaging(map,page);

        int expected = 4;
        int actual = pageOut.getList().size();
        assertEquals(expected, actual);
    }

    @Autowired
    public void setQuizSubmitService(QuizSubmitService quizSubmitService) {
        this.quizSubmitService = quizSubmitService;
    }
}