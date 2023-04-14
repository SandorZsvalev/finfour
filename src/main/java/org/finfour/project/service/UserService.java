package org.finfour.project.service;

import org.finfour.project.model.User;

public interface UserService {

    User getUser(int id);

    User createUser(String userName, String login, String password);

    User updateUser(User user);

    void deleteUserById(int id);

}
