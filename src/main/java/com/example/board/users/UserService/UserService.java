package com.example.board.users.UserService;

import com.example.board.users.UserEntity.UserModel;
import com.example.board.users.UserRepository.userRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    userRepository repository;

    public void deleteUser(Long id){
        UserModel user = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("User not exist"));
        repository.delete(user);
    }
}
