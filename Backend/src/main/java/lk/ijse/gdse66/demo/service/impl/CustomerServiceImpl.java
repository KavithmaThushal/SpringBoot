package lk.ijse.gdse66.demo.service.impl;

import lk.ijse.gdse66.demo.dto.CustomerDTO;
import lk.ijse.gdse66.demo.entity.Customer;
import lk.ijse.gdse66.demo.repository.CustomerRepository;
import lk.ijse.gdse66.demo.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CustomerRepository repository;

    public CustomerDTO save(CustomerDTO dto) {
        Customer customer = mapper.map(dto, Customer.class);
        Customer savedData = repository.save(customer);
        return mapper.map(savedData, CustomerDTO.class);
    }
}
