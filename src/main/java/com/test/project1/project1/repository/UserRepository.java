package com.test.project1.project1.repository;

import com.test.project1.project1.entity.JournalEntry;
import com.test.project1.project1.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String userName);
}
