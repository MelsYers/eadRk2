package kz.mels.pizzacatalog.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Pizza {

    private Long id;
    private String title;
    private Double price;
    private String description;
}
