package lk.ijse.gdse66.SpringBoot.repository;

import lk.ijse.gdse66.SpringBoot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}