package lk.ijse.gdse66.SpringBoot.service.impl;

import lk.ijse.gdse66.SpringBoot.dto.OrderDTO;
import lk.ijse.gdse66.SpringBoot.dto.OrderDetailDTO;
import lk.ijse.gdse66.SpringBoot.entity.Customer;
import lk.ijse.gdse66.SpringBoot.entity.Item;
import lk.ijse.gdse66.SpringBoot.entity.Order;
import lk.ijse.gdse66.SpringBoot.entity.OrderDetail;
import lk.ijse.gdse66.SpringBoot.repository.CustomerRepository;
import lk.ijse.gdse66.SpringBoot.repository.ItemRepository;
import lk.ijse.gdse66.SpringBoot.repository.OrderRepository;
import lk.ijse.gdse66.SpringBoot.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    public OrderDTO placeOrder(OrderDTO dto) {

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found!"));

        Order order = new Order();
        order.setDate(dto.getDate());
        order.setCustomer(customer);

        ArrayList<OrderDetail> orderDetailsList = new ArrayList<>();

        for (OrderDetailDTO items : dto.getOrderDetails()) {
            Item item = itemRepository.findById(items.getItemId())
                    .orElseThrow(() -> new RuntimeException("Item not found!"));

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setItem(item);
            orderDetail.setQuantity(items.getQuantity());
            orderDetail.setUnitPrice(items.getUnitPrice());
            orderDetail.setTotalPrice(items.getTotalPrice());
            orderDetail.setOrder(order);

            orderDetailsList.add(orderDetail);
        }

        order.setOrderDetails(orderDetailsList);

        Order placedOrder = orderRepository.save(order);

        OrderDTO savedDTO = new OrderDTO();
        savedDTO.setId(placedOrder.getId());
        savedDTO.setDate(placedOrder.getDate());
        savedDTO.setCustomerId(customer.getId());

        List<OrderDetailDTO> itemDetails = new ArrayList<>();
        for (OrderDetail detail : placedOrder.getOrderDetails()) {
            OrderDetailDTO detailDTO = mapper.map(detail, OrderDetailDTO.class);
            detailDTO.setItemId(detail.getItem().getId());
            detailDTO.setOrderId(placedOrder.getId());
            itemDetails.add(detailDTO);
        }

        savedDTO.setOrderDetails(itemDetails);

        return savedDTO;
    }
}