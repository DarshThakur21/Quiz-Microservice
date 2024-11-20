package com.Quiz.QuizMicroservice.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "quizdb")
public class QuizDto {
    String category;
    Integer numQuestions;
    String title;
}
