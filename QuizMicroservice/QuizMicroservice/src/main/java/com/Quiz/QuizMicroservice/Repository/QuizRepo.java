package com.Quiz.QuizMicroservice.Repository;

import com.Quiz.QuizMicroservice.Model.Quiz;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepo extends MongoRepository<Quiz,ObjectId> {
    Optional<Quiz> findById(ObjectId timestamp);
}
