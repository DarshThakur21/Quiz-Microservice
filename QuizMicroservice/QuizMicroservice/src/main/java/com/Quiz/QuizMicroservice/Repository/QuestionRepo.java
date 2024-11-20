package com.Quiz.QuizMicroservice.Repository;
import com.Quiz.QuizMicroservice.Model.QuestionDTO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends MongoRepository<QuestionDTO, Integer>
{
//    List<QuestionDTO> findByCategory(String category);

//    for jpa
//    @Query(value = "select * from question q where q.category=:category order BY Random() LIMIT :numQ " , nativeQuery=true)
//    List<Question> findRandomQuestionsByCategory(String category, int numQ);



//    for mongo
//    @Aggregation(pipeline = {
//            "{ '$match': { 'category': ?0 } }",
//            "{ '$sample': { 'size': ?1 } }"
//    })
//    List<ObjectId> findRandomQuestionsByCategory(String category, int numQ);

//    Question findById(int timestamp);

//    ScopedValue<Object> findById(ObjectId id);
}
