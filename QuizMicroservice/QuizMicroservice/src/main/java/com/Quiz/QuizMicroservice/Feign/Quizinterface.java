package com.Quiz.QuizMicroservice.Feign;

import com.Quiz.QuizMicroservice.Model.QuestionDTO;
import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTIONMICROSERVICE")
public interface Quizinterface {

    @GetMapping("question/generate")
    public ResponseEntity<List<ObjectId>> getQuestionForQuiz(@RequestParam String category, @RequestParam Integer numQuestion);
//it will return the quiz in the format of question wrt their ids so that user can play

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionDTO>> getQuestionFromId(@RequestBody List<ObjectId> qIds);
}
