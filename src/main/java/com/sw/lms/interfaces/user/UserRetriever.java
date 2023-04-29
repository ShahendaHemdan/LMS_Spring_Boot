package com.sw.lms.interfaces.user;

import java.util.List;

import com.sw.lms.model.User;

public interface UserRetriever {
    List<User> findAll();

    User findById(Long id);
}
