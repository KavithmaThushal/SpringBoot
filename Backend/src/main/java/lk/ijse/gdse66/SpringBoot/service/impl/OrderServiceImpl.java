package lk.ijse.gdse66.SpringBoot.service.impl;

import lk.ijse.gdse66.SpringBoot.dto.OrderDTO;
import lk.ijse.gdse66.SpringBoot.entity.Order;
import lk.ijse.gdse66.SpringBoot.repository.OrderRepository;
import lk.ijse.gdse66.SpringBoot.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private OrderRepository repository;

    public OrderDTO placeOrder(OrderDTO dto) {
        Order order = mapper.map(dto, Order.class);
        Order placedOrder = repository.save(order);
        return mapper.map(placedOrder, OrderDTO.class);
    }
}