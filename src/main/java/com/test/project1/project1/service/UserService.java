package com.test.project1.project1.service;

import com.test.project1.project1.entity.JournalEntry;
import com.test.project1.project1.entity.User;
import com.test.project1.project1.repository.JournalEntryRepository;
import com.test.project1.project1.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
            userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> getById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public  User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}
