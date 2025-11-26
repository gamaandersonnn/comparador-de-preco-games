package gama_project.comparador_preco_segundo_plano.service;

import gama_project.comparador_preco_segundo_plano.entity.dto.PriceComparisonResponse;
import gama_project.comparador_preco_segundo_plano.entity.dto.StorePriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gama_project.comparador_preco_segundo_plano.scraper.EpicScraper;
import gama_project.comparador_preco_segundo_plano.scraper.GogScraper;
import gama_project.comparador_preco_segundo_plano.scraper.NuuvemScraper;
import gama_project.comparador_preco_segundo_plano.scraper.SteamScraper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        List<StorePriceDTO> storePrices = new ArrayList<>();

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
