package com.Quiz.QuizMicroservice.Model;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "question")
public class Question {

    @Id
    private ObjectId _id;

    public ObjectId get_id() {
        return _id;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getCategory() {
        return category;
    }
//    private Integer id;

    private String question;
    private String[] options;
    private String answer;
    private String difficultyLevel;
    private String category;

    public Question(String question, String[] options, String answer, String difficultyLevel, String category) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.difficultyLevel = difficultyLevel;
        this.category = category;
    }


}
