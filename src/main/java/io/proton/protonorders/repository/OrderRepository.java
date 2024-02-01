package io.proton.protonorders.repository;

import io.proton.protonorders.model.Order;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@Slf4j
public class OrderRepository {

    private final JdbcClient jdbcClient;

    // ideally in a real life use case this would have pagination instead of returning all 300 orders
    public List<Order> getAllOrders() {
        return jdbcClient.sql("SELECT * FROM orders").query(Order.class).list();
    }
}
