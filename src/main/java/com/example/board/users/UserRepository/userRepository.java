package com.example.board.users.UserRepository;

import com.example.board.users.UserEntity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<UserModel,Long> {
}
