package com.example.EventManagement.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.EventManagement.dto.UserRequest;
import com.example.EventManagement.entities.Event;
import com.example.EventManagement.entities.User;
import com.example.EventManagement.repositories.EventRepository;
import com.example.EventManagement.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Autowired
    public UserService(UserRepository userRepository, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    public User createUser(@RequestBody UserRequest request) {
        User newUser = new User(request.getEmail(), request.getPassword());
        userRepository.save(newUser);
        return newUser;
    }

    public void updateUser(@PathVariable long id, @RequestBody UserRequest request) {
        User userToUpdate = this.userRepository.getUser(id);
        userToUpdate.setEmail(userToUpdate.getEmail());
        userToUpdate.setPassword(userToUpdate.getPassword());
        this.userRepository.save(userToUpdate);
    }

    public void deleteUserById(@PathVariable long id) {
        List<Event> temp = eventRepository.getAllEvents(id);

        for (int i = 0; i < temp.size(); i++) {
            temp.get(i).setUser(null);
        }
        User userToDelete = this.userRepository.getUser(id);
        this.userRepository.delete(userToDelete);
    }

    public List<User> getAllUsers() {
    return userRepository.getAllUsers();
    }

    public User getUserByEmail(@PathVariable String email) {
        return userRepository.getUserByEmail(email);
    }
}
