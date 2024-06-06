package com.example.board.users.UserEntity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;


@Getter
@Setter
@Table(name = "users")
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String login;
    private String password;

    public UserModel(UserResquestDTO data){
        this.name = data.name();
        this.login = data.email();
        this.password = data.password();
    }
}
