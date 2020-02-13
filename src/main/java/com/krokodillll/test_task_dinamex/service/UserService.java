package com.krokodillll.test_task_dinamex.service;

import com.krokodillll.test_task_dinamex.model.User;
import com.krokodillll.test_task_dinamex.repo.IUserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final
    IUserRepo userRepo;

    public UserService(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void create(User user) {
        userRepo.save(user);
    }

    public List<User> readAll() {
        return userRepo.findAll();
    }

    public User read(long id) {
        return userRepo.findUserById(id);
    }

    public boolean update(User user, long id) {
        User userFromDB = userRepo.findUserById(id);
        if(userFromDB != null) {
            user.setId(userFromDB.getId());
            userRepo.save(user);
            return true;
        }

        return false;
    }

    public boolean delete(long id) {
        User userFromDB = userRepo.findUserById(id);
        if(userFromDB != null) {
            userRepo.deleteUserById(id);
            return true;
        }
        return false;
    }
}
