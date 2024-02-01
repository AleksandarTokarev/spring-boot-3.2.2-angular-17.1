package io.proton.protonorders;


import io.proton.protonorders.exception.ProtonException;
import io.proton.protonorders.model.OrderLine;
import io.proton.protonorders.repository.OrderLineRepository;
import io.proton.protonorders.service.OrderLineService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

class OrderLineServiceTest {

    @InjectMocks
    OrderLineService orderLineService;
    @Mock
    OrderLineRepository orderLineRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testOrderLineFindById() throws ProtonException {
        Long id = 1L;
        OrderLine orderLine = OrderLine.builder().id(1L).orderId(2L).customerName("Cust 1").customerId("3").build();
        Mockito.when(orderLineService.getOrderLineById(id)).thenReturn(orderLine);
        OrderLine resultOrderLine = orderLineService.getOrderLineById(id);
        Assertions.assertEquals(resultOrderLine.getId(), id);
    }


    @Test
    void testGetOrderLines() {
        OrderLine orderLine = OrderLine.builder().id(1L).orderId(2L).customerName("Cust 1").customerId("3").build();
        OrderLine orderLine2 = OrderLine.builder().id(2L).orderId(2L).customerName("Cust 2").customerId("4").build();
        Mockito.when(orderLineService.getAllOrderLines()).thenReturn(Arrays.asList(orderLine, orderLine2));
        List<OrderLine> orderLines = orderLineService.getAllOrderLines();
        Assertions.assertEquals(orderLines.size(), 2);
    }
}
