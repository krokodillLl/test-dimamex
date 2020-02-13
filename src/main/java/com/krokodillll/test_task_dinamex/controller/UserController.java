package com.krokodillll.test_task_dinamex.controller;

import com.krokodillll.test_task_dinamex.model.Order;
import com.krokodillll.test_task_dinamex.model.User;
import com.krokodillll.test_task_dinamex.service.OrderService;
import com.krokodillll.test_task_dinamex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    final UserService userService;
    final OrderService orderService;

    public UserController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @PostMapping(value = "/user")
    public ResponseEntity<?> create(@RequestBody User user) {
        Set<Order> orders = user.getOrders();
        for(Order order: orders) {
            orderService.create(order);
        }
        userService.create(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<User>> read() {
        final List<User> users = userService.readAll();

        return users != null && !users.isEmpty() ? new ResponseEntity<>(users, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> read(@PathVariable(name = "id") long id) {
        final User user = userService.read(id);

        return user != null? new ResponseEntity<>(user, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/user/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody User user) {
        final boolean updated = userService.update(user, id);

        return updated ? new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = userService.delete(id);

        return deleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }



}
