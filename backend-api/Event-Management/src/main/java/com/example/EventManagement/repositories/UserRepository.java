package com.example.EventManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.EventManagement.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT user FROM User user WHERE user.Id = :ID")
    public User getUser(long ID);

    @Query("SELECT user FROM User user")
    public List<User> getAllUsers();

    @Query("SELECT user FROM User user WHERE user.email = :email")
    public User getUserByEmail(String email);
}
