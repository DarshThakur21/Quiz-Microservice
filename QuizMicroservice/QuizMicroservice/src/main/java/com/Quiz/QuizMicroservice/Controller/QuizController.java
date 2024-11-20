package com.Quiz.QuizMicroservice.Controller;

import com.Quiz.QuizMicroservice.Model.QuestionDTO;
import com.Quiz.QuizMicroservice.Model.QuizDto;
import com.Quiz.QuizMicroservice.Service.QuizService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto  ){

//        new ResponseEntity<>("this is quiz controller", HttpStatus.CREATED);
        return  quizService.createQuiz(quizDto.getCategory(),quizDto.getNumQuestions(),quizDto.getTitle());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionDTO>> getQuizQuestion(@PathVariable ObjectId id){
        List<QuestionDTO> questionDTOS= quizService.getQuizQuestions(id);


        return new ResponseEntity<List<QuestionDTO>>(questionDTOS,HttpStatus.OK);
    }

}
