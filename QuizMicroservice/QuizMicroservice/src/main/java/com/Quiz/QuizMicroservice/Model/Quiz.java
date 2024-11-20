package com.Quiz.QuizMicroservice.Model;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonExtraElements;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "quiz")
public class Quiz {

    @Id
    private ObjectId _id;

    private String title;



    private List<ObjectId> questions;

}
