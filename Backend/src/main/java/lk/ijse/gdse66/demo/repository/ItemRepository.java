package lk.ijse.gdse66.demo.repository;

import lk.ijse.gdse66.demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}