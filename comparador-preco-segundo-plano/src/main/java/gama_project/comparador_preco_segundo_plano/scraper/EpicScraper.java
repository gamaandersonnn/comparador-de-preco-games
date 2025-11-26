package gama_project.comparador_preco_segundo_plano.scraper;

import gama_project.comparador_preco_segundo_plano.entity.dto.StorePriceDTO;
import org.springframework.stereotype.Component;

@Component
public class EpicScraper {

    public StorePriceDTO search(String gameName){

        try {

            return new StorePriceDTO(
                    "Epic Games",
                    12.12,
                    "https://store.epicgames.com/en-US/browse?q=" + gameName
            );

        } catch (Exception e) {
            return null;
        }
    }
}
