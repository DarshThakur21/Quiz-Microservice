package com.Quiz.QuestionMicroservice.Service.Impl;

import com.Quiz.QuestionMicroservice.Model.Question;
import com.Quiz.QuestionMicroservice.Model.QuestionDTO;
import com.Quiz.QuestionMicroservice.Repository.QuestionRepo;
import com.Quiz.QuestionMicroservice.Service.QuestionService;
//import com.quizmicroservice.quizapp.Model.Question;
//import com.quizmicroservice.quizapp.Repository.QuestionRepo;
//import com.quizmicroservice.quizapp.Service.QuestionService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepo questionRepo;


    @Override
    public List<Question> getAllQuestion() {
            List<Question> questions=questionRepo.findAll();

        return questions;
    }

    @Override
    public List<Question> findByCategory(String category) {
        List<Question> catq=questionRepo.findByCategory(category);
        return  catq;
    }

    @Override
    public Question findBYId(ObjectId id) {
        return questionRepo.findById(id.getTimestamp());
    }

    @Override
    public Question saveQuestion(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public ResponseEntity<List<ObjectId>> getQuestionForQuiz(String category, Integer numQuestion) {

        List<ObjectId> questions=questionRepo.findRandomQuestionsByCategory(category,numQuestion);



        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<QuestionDTO>> getQuestionFromId(List<ObjectId> qIds) {
        List<QuestionDTO> wrapper=new ArrayList<>();
        List<Question> questions=new ArrayList<>();

        for(ObjectId id:qIds){
            questions.add(questionRepo.findById(id.getTimestamp()));

        }
        for (Question question:questions){
            QuestionDTO wrapperDto=new QuestionDTO();
            wrapperDto.set_id(question.get_id());
            wrapperDto.setQuestion(question.getQuestion());
            wrapperDto.setOptions(question.getOptions());
            wrapper.add(wrapperDto);
        }

        return new ResponseEntity<>(wrapper,HttpStatus.OK);

    }

//    @Override
//    public void saveAllQuestion(List<Question> questions) {
//        questionRepo.saveAll(questions);
//    }


}
