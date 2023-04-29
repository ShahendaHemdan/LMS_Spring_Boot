package com.sw.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sw.lms.model.User;

public interface userRepository extends JpaRepository<User, Long> {

}
