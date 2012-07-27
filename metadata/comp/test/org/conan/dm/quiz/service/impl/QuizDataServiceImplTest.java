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

import org.conan.dm.quiz.service.QuizDataService;
import org.conan.dm.quiz.model.QuizDataDTO;

import static org.junit.Assert.assertEquals;

/**
 * This is Test of QuizData Service implemention
 * @author Conan Zhang
 * @date 2012-07-27
 */
public class QuizDataServiceImplTest extends BaseTestCase {

    private QuizDataService quizDataService;
    private QuizDataDTO dto;

    public QuizDataServiceImplTest() {
    }

    @Before
    public void setUp() {
        dto = new QuizDataDTO();
    }

    @After
    public void tearDown() {
        dto = null;
    }

    @Test
    public void insertQuizData() {
        boolean expected = true;
        int actual = quizDataService.insertQuizData(dto);
        assertEquals(expected, actual > 1);
    }

    @Test
    public void deleteQuizData() {
        int expected = 1;
        int actual = quizDataService.deleteQuizData(1);
        assertEquals(expected, actual);
    }

    @Test
    public void updateQuizData() {
        dto.setId(2);

        int expected = 1;
        int actual = quizDataService.updateQuizData(dto);
        assertEquals(expected, actual);
    }

    @Test
    public void getQuizDataById() {
        QuizDataDTO tmp = quizDataService.getQuizDataById(1);

        int expected = 1;
        int actual = tmp.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void getQuizDatas() {
        List<QuizDataDTO> list = quizDataService.getQuizDatas(null);

        int expected = 1;
        int actual = list.get(0).getId();
        assertEquals(expected, actual);
    }

    @Test
    public void getQuizDatasPaging() {
        Map<String,Object> map = new HashMap<String,Object>();
        PageInObject page = new PageInObject(0, 4, "id", "asc");

        PageOutObject<QuizDataDTO> pageOut = quizDataService.getQuizDatasPaging(map,page);

        int expected = 4;
        int actual = pageOut.getList().size();
        assertEquals(expected, actual);
    }

    @Autowired
    public void setQuizDataService(QuizDataService quizDataService) {
        this.quizDataService = quizDataService;
    }
}