package com.example.board.users.UserController;

import com.example.board.users.UserEntity.UserDTO;
import com.example.board.users.UserEntity.UserModel;
import com.example.board.users.UserEntity.UserResquestDTO;
import com.example.board.users.UserRepository.userRepository;
import com.example.board.users.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private userRepository repository;

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDTO> getUsers(){
        List<UserDTO> users = repository.findAll().stream().map(UserDTO::new).toList();
        return users;
    }

    @PostMapping
    public void createUser(@RequestBody UserResquestDTO data){
        UserModel userModel = new UserModel(data);
        repository.save(userModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("user delete with sucess");

        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
