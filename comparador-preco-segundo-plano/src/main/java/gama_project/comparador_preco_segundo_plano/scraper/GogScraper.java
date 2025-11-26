package gama_project.comparador_preco_segundo_plano.scraper;

import gama_project.comparador_preco_segundo_plano.entity.dto.StorePriceDTO;
import org.springframework.stereotype.Component;

@Component
public class GogScraper {

    public StorePriceDTO search(String gameName){

        try {

            return new StorePriceDTO(
                    "Gog",
                    31.32,
                    "https://www.gog.com/en/game/" + formatName(gameName)
            );

        } catch (Exception e) {
            return null;
        }
    }

    private String formatName(String name){
        return name.toLowerCase().replace(" ", "_");
    }
}
