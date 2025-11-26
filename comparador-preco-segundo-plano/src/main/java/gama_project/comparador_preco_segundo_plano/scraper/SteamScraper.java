package gama_project.comparador_preco_segundo_plano.scraper;

import gama_project.comparador_preco_segundo_plano.entity.dto.StorePriceDTO;
import org.springframework.stereotype.Component;

@Component
public class SteamScraper {

    public StorePriceDTO search(String gameName){

        try {

            return new StorePriceDTO(
                    "Steam",
                    49.90,
                    "https://store.steampowered.com/search/?term=" + gameName
            );

        } catch (Exception e) {
            return null;
        }
    }
}
