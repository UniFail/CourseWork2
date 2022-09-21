package com.example.CourseWork2;

import com.example.CourseWork2.domain.Question;
import com.example.CourseWork2.exception.QuestionNotFound;
import com.example.CourseWork2.service.JavaQuestionService;
import com.example.CourseWork2.service.QuestionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.Collection;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class JavaQuestionServiceTest {



    private final QuestionService questionService = new JavaQuestionService();

    @AfterEach
    public  void  afterEach(){
        Collection<Question> questions = questionService.getAll();
        questions.forEach(questionService::removeQuestion);
    }
    @Test
    public void removeTest() {
        assertThat(questionService.getAll().isEmpty());
        Question expected = addOneQuestion();
        assertThatExceptionOfType(QuestionNotFound.class)
                .isThrownBy(() -> questionService.removeQuestion(new Question("Q2", "A2")));
        questionService.removeQuestion(expected);
        assertThat(questionService.getAll().isEmpty());

    }
    @Test
    public void CheckAddQuestion(){
        Question expected1 = new Question("Q","A");
        questionService.addQuestion(expected1);
        assertThat(questionService.getAll()).hasSize(1);
    }

    @Test
    public void getRandomQuestionTest(){
        assertThat(questionService.getAll()).isEmpty();
        int size = 5;
        for (int i = 0; i < size; i++) {
            addOneQuestion("Q" + 1, "A" + 1);
        }
        assertThat(questionService.getAll()).hasSize(size);
        assertThat(questionService.getRandomQuestion());
    }

    private Question addOneQuestion(String question, String answer){
        int size = questionService.getAll().size();
        Question expected = new Question(question,answer);
        questionService.addQuestion(expected);
        assertThat(questionService.getAll()).hasSize(size + 1);
        assertThat(questionService.getAll()).contains(expected);
        return expected;
    }

    private Question addOneQuestion(){
        Question expected = new Question("Q","A");
        questionService.addQuestion(expected);
        assertThat(questionService.getAll()).hasSize(1);
        assertThat(questionService.getAll()).contains(expected);
        return expected;
    }
}
