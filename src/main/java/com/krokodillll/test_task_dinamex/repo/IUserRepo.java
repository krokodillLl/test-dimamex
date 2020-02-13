package com.krokodillll.test_task_dinamex.repo;

import com.krokodillll.test_task_dinamex.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Long> {
    User findUserById(long id);
    boolean deleteUserById(long id);
}
