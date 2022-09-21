package com.example.CourseWork2.service;

import com.example.CourseWork2.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}
