package com.example.projectMara.adapter.repository;

import com.example.projectMara.domain.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDao extends CrudRepository<User, Integer> {
    Optional<User> findById(Integer id);
    User findByNickName(String nickName);
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
    Boolean existsByNickName(String nickName);
}
