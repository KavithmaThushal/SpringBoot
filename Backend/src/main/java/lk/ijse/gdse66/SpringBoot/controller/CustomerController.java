package lk.ijse.gdse66.SpringBoot.controller;

import jakarta.validation.Valid;
import lk.ijse.gdse66.SpringBoot.dto.CustomerDTO;
import lk.ijse.gdse66.SpringBoot.service.CustomerService;
import lk.ijse.gdse66.SpringBoot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseUtil save(@Valid @RequestBody CustomerDTO dto) {
        CustomerDTO data = service.save(dto);
        return new ResponseUtil("Customer saved successfully!", data);
    }
}