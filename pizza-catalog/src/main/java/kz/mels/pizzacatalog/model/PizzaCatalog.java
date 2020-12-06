package kz.mels.pizzacatalog.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PizzaCatalog {

    private Long pizzaId;
    private String title;
    private Double price;
    private Integer rating;

}
