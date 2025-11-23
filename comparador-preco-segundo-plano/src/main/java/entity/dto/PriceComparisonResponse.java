package entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter

public class PriceComparisonResponse {

    private String game;
    private String bestStore;
    private double bestPrice;
    private List<StorePriceDTO> stores;

}
