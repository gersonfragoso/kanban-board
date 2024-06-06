package com.example.board.users.UserEntity;

public record UserDTO (Long id, String name, String login, String password){
    public UserDTO(UserModel user){
        this(user.getId(),user.getName(),user.getLogin(),user.getPassword());

    }
}
