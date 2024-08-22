package org.mongo.mongodb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskBoardRepo extends MongoRepository<TaskBoard,String>{

}
