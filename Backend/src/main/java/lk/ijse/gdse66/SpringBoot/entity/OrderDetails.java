package lk.ijse.gdse66.SpringBoot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;
    private double unitPrice;
    private double total;

    @ManyToOne
    @NotNull
    private Item item;

    @ManyToOne
    @NotNull
    private Orders order;
}