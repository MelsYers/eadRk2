package kz.mels.pizzacatalog.controller;

import kz.mels.pizzacatalog.model.Pizza;
import kz.mels.pizzacatalog.model.PizzaCatalog;
import kz.mels.pizzacatalog.service.PizzaInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaCatalogController {

    @Autowired
    private PizzaInfoService pizzaInfoService;

    @GetMapping("")
    public ResponseEntity<?> getUserPizzaCatalog(){
        //get list og pizza for user
        //get ratings for each pizza
        List<Pizza> userPizza = pizzaInfoService.getUserPizza();

        List<PizzaCatalog> userPizzaCatalog = new ArrayList<>();
        for(Pizza pizza : userPizza){
            PizzaCatalog pizzaCatalog = new PizzaCatalog();
            pizzaCatalog.setPizzaId(pizza.getId());
            pizzaCatalog.setPrice(pizza.getPrice());
            pizzaCatalog.setTitle(pizza.getTitle());

        //    Rating rating = pizzaRatingService.getPizzaRating(pizza.getId());
    //        pizzaCatalog.setRating(rating.getRating());
            userPizzaCatalog.add(pizzaCatalog);
        }

        return ResponseEntity.ok(userPizzaCatalog);
    }

    @GetMapping("/{pizzaId}")
    public ResponseEntity<?> getPizzaById(@PathVariable Long pizzaId){
        Pizza pizza = pizzaInfoService.getPizza(pizzaId);
        Pizza pizza1 = new Pizza();

        pizza1.setId(pizza.getId());
        pizza1.setPrice(pizza.getPrice());
        pizza1.setTitle(pizza.getTitle());
        pizza1.setDescription(pizza.getDescription());

        return ResponseEntity.ok(pizza1);
    }
}
