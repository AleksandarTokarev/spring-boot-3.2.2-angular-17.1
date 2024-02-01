package io.proton.protonorders.controller;

import io.proton.protonorders.dto.OrderLineDTO;
import io.proton.protonorders.exception.ProtonException;
import io.proton.protonorders.model.OrderLine;
import io.proton.protonorders.service.OrderLineService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
@Slf4j
public class OrderLineController {

    private final OrderLineService orderService;

    @GetMapping("")
    List<OrderLine> getAllOrderLines() {
        return orderService.getAllOrderLines();
    }

    @GetMapping("/{id}")
    OrderLine getOrderLineById(@PathVariable Long id) throws ProtonException {
        return orderService.getOrderLineById(id);
    }

    @PatchMapping("/{id}")
    void updateOrderLineById(@RequestBody OrderLineDTO orderLineDTO, @PathVariable Long id) throws ProtonException {
            if (!Objects.equals(id, orderLineDTO.getId())) {
            throw new ProtonException(HttpStatus.BAD_REQUEST, "Provided ids do not match", "Provided ids do not match:" + id + " and " + orderLineDTO.getId());
        }
        orderService.markFollowUpOrder(id, orderLineDTO.getFollowUp());
    }

    @DeleteMapping("/{id}")
    void deleteOrderLineById(@PathVariable Long id) throws ProtonException {
        orderService.deleteOrderLineById(id);
    }
}
