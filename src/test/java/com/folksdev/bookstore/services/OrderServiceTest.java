package com.folksdev.bookstore.services;

import com.folksdev.bookstore.model.Order;
import com.folksdev.bookstore.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.isA;

public class OrderServiceTest {

    private OrderService orderService;
    private BookService bookService;
    private OrderRepository orderRepository;
    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    public OrderServiceTest() {
    }

    @Before
    public void setUp() throws Exception {
        bookService = Mockito.mock(BookService.class);
        orderRepository = Mockito.mock(OrderRepository.class);
        logger = Mockito.mock(Logger.class);
        orderService = new OrderService(bookService, orderRepository);
    }

    @Test
    public void whenPutAndOrderCalledWithValidRequest_itShouldReturnOrder() {
        //given
        List<Integer> bookIdList = new ArrayList<>();
        bookIdList.add(44);
        bookIdList.add(55);
        String userName = "mustafaikili";

        //when
        Order order = orderService.putAndOrder(bookIdList, userName);

        //then
        Mockito.verify(orderRepository).save(isA(Order.class));

    }
}