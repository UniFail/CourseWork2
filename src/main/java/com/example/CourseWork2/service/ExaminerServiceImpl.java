package com.example.CourseWork2.service;

import com.example.CourseWork2.domain.Question;
import com.example.CourseWork2.exception.SizeOverException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private QuestionService questionService;

    public ExaminerServiceImpl() {

        this.questionService = questionService;
    }

    public Collection<Question> getQuestion(int amount) {
        Set<Question> randomQuestions = new HashSet<>();

        if (questionService.getQuestions().size() < amount) {
            throw new SizeOverException();

        }
        for (int i = 0; i < amount; i++) {

            randomQuestions.add(questionService.getRandomQuestion());

        }
        return randomQuestions.stream()
                .toList();
    }
}
