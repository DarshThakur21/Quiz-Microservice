package com.Quiz.QuestionMicroservice.Service;

import com.Quiz.QuestionMicroservice.Model.Question;
//import com.quizmicroservice.quizapp.Model.Question;
import com.Quiz.QuestionMicroservice.Model.QuestionDTO;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {


    List<Question> getAllQuestion();

    List<Question> findByCategory(String category);

    Question findBYId(ObjectId id);

    Question saveQuestion(Question question);

    ResponseEntity<List<ObjectId>> getQuestionForQuiz(String category, Integer numQuestion);

    ResponseEntity<List<QuestionDTO>> getQuestionFromId(List<ObjectId> qIds);

//    standby
//    void saveAllQuestion(List<Question> questions);
}
