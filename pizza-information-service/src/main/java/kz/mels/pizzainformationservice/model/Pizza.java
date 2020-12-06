package kz.mels.pizzainformationservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pizza {

    private Long id;
    private String title;
    private Double price;
    private String description;

}
