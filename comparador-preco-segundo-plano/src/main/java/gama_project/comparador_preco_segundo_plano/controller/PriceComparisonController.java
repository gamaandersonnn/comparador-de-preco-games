package gama_project.comparador_preco_segundo_plano.controller;

import gama_project.comparador_preco_segundo_plano.entity.dto.GameRequest;
import gama_project.comparador_preco_segundo_plano.entity.dto.PriceComparisonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gama_project.comparador_preco_segundo_plano.service.PriceComparisonService;

@RestController
@RequestMapping("/api/v1/prices")
@CrossOrigin(origins = "*")
public class PriceComparisonController {

    private final PriceComparisonService priceComparisonService;

    public PriceComparisonController(PriceComparisonService priceComparisonService) {
        this.priceComparisonService = priceComparisonService;
    }

    @PostMapping("/compare")
    public ResponseEntity<PriceComparisonResponse> compare(@RequestBody GameRequest gameRequest){

        if (gameRequest.getGameName() == null || gameRequest.getGameName().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        PriceComparisonResponse response = priceComparisonService.comparePrices(gameRequest.getGameName());

        return ResponseEntity.ok(response);
    }
}
