package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class PriceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String store;
    private double price;
    private LocalDateTime checkedAt;

    @ManyToMany
    private Game game;
}
