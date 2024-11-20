package com.Quiz.QuizMicroservice.Service;

import com.Quiz.QuizMicroservice.Model.QuestionDTO;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {


    ResponseEntity<String> createQuiz(String category, Integer numQ, String title);

    List<QuestionDTO> getQuizQuestions(ObjectId id);
}
