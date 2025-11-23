package service;

import entity.dto.PriceComparisonResponse;
import entity.dto.StorePriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PriceComparisonService {

    @Autowired
    SteamScraper steamScraper;

    @Autowired
    GogScraper gogScraper;

    @Autowired
    NuuvemScraper nuuvemScraper;

    @Autowired
    EpicScraper epicScraper;

    public PriceComparisonResponse comparePrices(String gameName){
        // chama os Scrappers
        List<StorePriceDTO> storePrices = new List<StorePriceDTO>();

        storePrices.add(steamScraper.search(gameName));
        storePrices.add(gogScraper.search(gameName));
        storePrices.add(nuuvemScraper.search(gameName));
        storePrices.add(epicScraper.search(gameName));

        // descarta os preços invalidos
        List<StorePriceDTO> validPrices = storePrices.stream()
                .filter(p -> p != null && p.getPrice() > 0)
                .toList();

        // verificacao do mais barato
        StorePriceDTO best = validPrices.stream()
                .min(Comparator.comparing(StorePriceDTO::getPrice))
                .orElse(null);

        return new PriceComparisonResponse(
                gameName,
                best != null ? best.getStore() : "Nenhuma loja encontrada",
                best != null ? best.getPrice() : 0.0,
                validPrices
        );
    }
}
