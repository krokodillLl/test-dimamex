package com.krokodillll.test_task_dinamex.repo;

import com.krokodillll.test_task_dinamex.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Order, Long> {
}
