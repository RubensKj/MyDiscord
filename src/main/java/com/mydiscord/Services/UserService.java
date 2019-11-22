package com.mydiscord.Services;

import com.mydiscord.Exceptions.UserNotFoundByIdException;
import com.mydiscord.Models.User;
import com.mydiscord.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) throws UserNotFoundByIdException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundByIdException("User with id equals " + id + ", wasn't found."));
    }

    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

}
