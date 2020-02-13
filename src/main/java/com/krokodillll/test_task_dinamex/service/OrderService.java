package com.krokodillll.test_task_dinamex.service;

import com.krokodillll.test_task_dinamex.model.Order;
import com.krokodillll.test_task_dinamex.repo.IOrderRepo;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    final IOrderRepo orderRepo;

    public OrderService(IOrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public void create(Order order) {
        orderRepo.save(order);
    }
}
