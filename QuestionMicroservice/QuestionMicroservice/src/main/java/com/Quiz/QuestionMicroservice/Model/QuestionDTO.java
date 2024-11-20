package com.Quiz.QuestionMicroservice.Model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@Getter
@Setter
//@AllArgsConstructor
public class QuestionDTO {


    @Id
    private ObjectId _id;
    private String question;
    private String[] options;

    public QuestionDTO(ObjectId _id, String question, String[] options) {
        this._id = _id;
        this.question = question;
        this.options = options;
    }
}
