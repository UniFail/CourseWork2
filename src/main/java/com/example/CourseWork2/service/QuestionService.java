package com.example.CourseWork2.service;

import com.example.CourseWork2.domain.Question;

import java.util.Collection;
import java.util.Set;

public interface QuestionService {
    Question addQuestion(Question question);

    Collection<Question> getAll();

    Question removeQuestion(Question question);
    Question getRandomQuestion();
    Set<Question> getQuestions();
}
