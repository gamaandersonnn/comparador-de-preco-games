package gama_project.comparador_preco_segundo_plano.scraper;

import gama_project.comparador_preco_segundo_plano.entity.dto.StorePriceDTO;
import org.springframework.stereotype.Component;

@Component
public class NuuvemScraper {

    public StorePriceDTO search(String gameName){

        try {

            return new StorePriceDTO(
                    "Nuuvem",
                    87.21,
                    "https://www.nuuvem.com/br-pt/search?q=" + gameName
            );

        } catch (Exception e) {
            return null;
        }
    }
}
