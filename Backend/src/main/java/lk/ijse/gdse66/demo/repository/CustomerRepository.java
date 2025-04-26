package lk.ijse.gdse66.demo.repository;

import lk.ijse.gdse66.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}