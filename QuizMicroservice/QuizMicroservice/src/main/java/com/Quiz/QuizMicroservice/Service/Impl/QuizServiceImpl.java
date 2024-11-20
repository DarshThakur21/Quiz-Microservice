package com.Quiz.QuizMicroservice.Service.Impl;

import com.Quiz.QuizMicroservice.Feign.Quizinterface;
import com.Quiz.QuizMicroservice.Model.Question;
import com.Quiz.QuizMicroservice.Model.QuestionDTO;
import com.Quiz.QuizMicroservice.Model.Quiz;
import com.Quiz.QuizMicroservice.Repository.QuestionRepo;
import com.Quiz.QuizMicroservice.Repository.QuizRepo;
import com.Quiz.QuizMicroservice.Service.QuizService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionRepo questionRepo;


    @Autowired
    Quizinterface quizinterface;

    @Override
    public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {
        List<ObjectId> questions= quizinterface.getQuestionForQuiz(category, numQ).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @Override
    public List<QuestionDTO> getQuizQuestions(ObjectId id) {
//        Optional<Quiz> quiz = quizRepo.findById(id);
//
//        List<Question> questionsdb = quiz.get().getQuestions();
//
        List<QuestionDTO> questionDTOS = new ArrayList<>();
//        for (Question q : questionsdb) {
//            QuestionDTO questionDTO = new QuestionDTO(q.get_id(), q.getQuestion(), q.getOptions());
//            questionDTOS.add(questionDTO);
//
//        }
        return questionDTOS;
    }

}
