package lk.ijse.gdse66.SpringBoot.controller;

import jakarta.validation.Valid;
import lk.ijse.gdse66.SpringBoot.dto.OrderDTO;
import lk.ijse.gdse66.SpringBoot.service.OrderService;
import lk.ijse.gdse66.SpringBoot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseUtil placeOrder(@Valid @RequestBody OrderDTO dto) {
        OrderDTO data = service.placeOrder(dto);
        return new ResponseUtil("Order placed successfully!", data);
    }
}