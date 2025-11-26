package gama_project.comparador_preco_segundo_plano.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<PriceHistory> priceHistory = new ArrayList<>();
}
