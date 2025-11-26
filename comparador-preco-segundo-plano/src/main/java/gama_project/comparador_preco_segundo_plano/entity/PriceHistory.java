package gama_project.comparador_preco_segundo_plano.entity;

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

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
}
