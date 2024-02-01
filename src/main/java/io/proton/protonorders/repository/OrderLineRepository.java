package io.proton.protonorders.repository;

import io.proton.protonorders.exception.ProtonException;
import io.proton.protonorders.model.OrderLine;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@Slf4j
public class OrderLineRepository {

    private final JdbcClient jdbcClient;

    // ideally in a real life use case this would have pagination instead of returning all 300 orders
    public List<OrderLine> getAllOrderLines() {
        return jdbcClient.sql("SELECT * FROM order_lines").query(OrderLine.class).list();
    }

    public OrderLine getOrderLineById(Long id) throws ProtonException {
        Optional<OrderLine> optionalOrderLine =  jdbcClient.sql("SELECT * FROM order_lines WHERE id = :id")
                .param("id", id)
                .query(OrderLine.class)
                .optional();
        if (optionalOrderLine.isPresent()) {
            return optionalOrderLine.get();
        } else {
            throw new ProtonException(HttpStatus.NOT_FOUND, "Item with id:" + id + " not found", "Item not found");
        }
    }

    public void markFollowUpOrder(Long id, Boolean followUp) {
        jdbcClient.sql("UPDATE order_lines SET follow_up = :followUp WHERE id = :id")
                .param("followUp", followUp)
                .param("id", id)
                .update();
    }

    public void deleteOrderLineById(Long id) throws ProtonException {
        int update = jdbcClient.sql("DELETE FROM order_lines WHERE id = :id")
                .param("id", id)
                .update();
        if (update != 1) {
            throw new ProtonException(HttpStatus.NOT_FOUND, "Item with id:" + id + " not found", "Item not found");
        }
    }
}
