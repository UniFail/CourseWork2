package com.example.CourseWork2.controller;

import com.example.CourseWork2.domain.Question;
import com.example.CourseWork2.service.JavaQuestionService;
import com.example.CourseWork2.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/java")
public class JavaController {

    private JavaQuestionService javaQuestionService;


    public JavaController(JavaQuestionService javaQuestionService) {

        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/add")
    public Question addQuestion(Question question) {
        return javaQuestionService.addQuestion(question);
    }

    @GetMapping(path = "/get")
    public Collection<Question> getQuestion() {
        return javaQuestionService.getAll();
    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(String question, String answer) {
        Question question1 = new Question(question, answer);
        return javaQuestionService.removeQuestion(question1);
    }


}
