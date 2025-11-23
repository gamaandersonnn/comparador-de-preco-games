package entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class StorePriceDTO {

    private String store;
    private double price;
    private String url;

}
