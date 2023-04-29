package com.sw.lms.interfaces.user;

import com.sw.lms.model.User;

public interface UserUpdater {
    User update(User updatedUser, Long id);

}
