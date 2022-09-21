package com.example.CourseWork2.service;

import com.example.CourseWork2.domain.Question;
import com.example.CourseWork2.exception.AnswerNullException;
import com.example.CourseWork2.exception.QuestionNotFound;
import com.example.CourseWork2.exception.QuestionNullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final int size = 5;
    private Set<Question> questions;
    private Random random;

    public JavaQuestionService() {
        this.questions = new HashSet<>(size);
        this.random = new Random();
    }

    public Question addQuestion(Question question) {

        if (question.getQuestion() == null)
            throw new QuestionNullException("The question should not be empty");

        if (question.getAnswer() == null)
            throw new AnswerNullException("The answer should not be empty");

        questions.add(question);
        return question;
    }

    public Collection<Question> getAll() {
        return questions.stream().toList();
    }

    public Question removeQuestion(Question question) {
        if (!questions.contains(question))
            throw new QuestionNotFound("The question not found");
        questions.remove(question);
        return question;
    }

    public Question getRandomQuestion() {
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }

    public Set<Question> getQuestions() {
        return questions;
    }
}
