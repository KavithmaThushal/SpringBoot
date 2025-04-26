package lk.ijse.gdse66.demo.controller;

import lk.ijse.gdse66.demo.dto.CustomerDTO;
import lk.ijse.gdse66.demo.service.CustomerService;
import lk.ijse.gdse66.demo.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseUtil save(@RequestBody CustomerDTO dto) {
        CustomerDTO data = service.save(dto);
        return new ResponseUtil("Customer saved successfully!", data);
    }
}