package org.finfour.project.service;

import org.finfour.project.model.User;
import org.finfour.project.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {
    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
    }

    @Override
    public User createUser(String userName, String login, String password) {
        if (userName.isEmpty() || (userName.isBlank())) {
            log.error("Empty user name");
            throw new IllegalArgumentException("Empty user name");
        }
        if (login.isEmpty() || (login.isBlank())) {
            log.error("Empty login");
            throw new IllegalArgumentException("Empty login");
        }
        if (password.isEmpty() || (password.isBlank())) {
            log.error("Empty password");
            throw new IllegalArgumentException("Empty password");
        }
        User user = new User();
        user.setName(userName);
        user.setLogin(login);
        user.setPass(password);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if (user.getId()==0){
            log.error("Empty user id");
            throw new IllegalArgumentException("Empty user id");
        }
       User oldVersion = userRepository.findById(user.getId())
                .orElseThrow(() -> new EntityNotFoundException("User with id " + user.getId() + " not found"));
        oldVersion.setName(user.getName());
        oldVersion.setLogin(user.getLogin());
        oldVersion.setPass(user.getPass());
        return userRepository.save(oldVersion);
    }

    @Override
    public void deleteUserById(int id) {
        User user = getUser(id);
        if (user != null) {
            userRepository.delete(user);
        }
    }
}
