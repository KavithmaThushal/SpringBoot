package lk.ijse.gdse66.SpringBoot.service.impl;

import lk.ijse.gdse66.SpringBoot.dto.CustomerDTO;
import lk.ijse.gdse66.SpringBoot.entity.Customer;
import lk.ijse.gdse66.SpringBoot.repository.CustomerRepository;
import lk.ijse.gdse66.SpringBoot.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO save(CustomerDTO dto) {
        Customer customer = modelMapper.map(dto, Customer.class);
        Customer savedData = customerRepository.save(customer);
        return modelMapper.map(savedData, CustomerDTO.class);
    }
}
