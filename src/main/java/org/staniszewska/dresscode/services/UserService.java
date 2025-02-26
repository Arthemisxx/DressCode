package org.staniszewska.dresscode.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.staniszewska.dresscode.entities.User;
import org.staniszewska.dresscode.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> allUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        return users;
    }
}
