package com.sw.lms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.lms.interfaces.user.UserDeleter;
import com.sw.lms.interfaces.user.UserRetriever;
import com.sw.lms.interfaces.user.UserSaver;
import com.sw.lms.interfaces.user.UserUpdater;
import com.sw.lms.model.User;
import com.sw.lms.repository.userRepository;

@Service
public class adminManageUserService implements UserDeleter, UserUpdater, UserSaver, UserRetriever {
    @Autowired
    public userRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User updatedUser, Long id) {
        Optional<User> oldEUser = userRepository.findById(id);
        if (oldEUser.isPresent()) {
            User user = oldEUser.get();
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setRole(updatedUser.getRole());
            return userRepository.save(user);
        } else
            return null;
    }

}
