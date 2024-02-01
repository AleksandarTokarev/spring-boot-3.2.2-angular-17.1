package io.proton.protonorders.service;

import io.proton.protonorders.exception.ProtonException;
import io.proton.protonorders.model.OrderLine;
import io.proton.protonorders.repository.OrderLineRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class OrderLineService {

    private final OrderLineRepository orderRepository;

    public List<OrderLine> getAllOrderLines() {
        return orderRepository.getAllOrderLines();
    }

    public void markFollowUpOrder(Long id, Boolean followUp) {
        orderRepository.markFollowUpOrder(id, followUp);
    }

    public OrderLine getOrderLineById(Long id) throws ProtonException {
        return orderRepository.getOrderLineById(id);
    }

    public void deleteOrderLineById(Long id) throws ProtonException {
        orderRepository.deleteOrderLineById(id);
    }
}
