package gama_project.comparador_preco_segundo_plano.repository;

import gama_project.comparador_preco_segundo_plano.entity.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Long> {

}
