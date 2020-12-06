package kz.mels.pizzacatalog.model;

import lombok.Data;

@Data
public class Rating {

    private Long pizzaId;
    private Integer rating;
}
