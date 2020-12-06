package kz.mels.pizzainformationservice.controller;

import kz.mels.pizzainformationservice.model.Pizza;
import kz.mels.pizzainformationservice.model.UserPizza;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pizza/info")
public class PizzaController {


    @GetMapping("")
    public ResponseEntity<?> getUserPizza(){
        System.out.println("PizzaController.getUserPizza");

        List<Pizza> userPizza = new ArrayList<>();

        userPizza.add(Pizza.builder().id(1L).title("TestPizza1101010").price(1200.0).build());
        userPizza.add(Pizza.builder().id(2L).title("TestPizza2").price(1300.0).build());
        userPizza.add(Pizza.builder().id(3L).title("TestPizza3").price(1400.0).build());
        userPizza.add(Pizza.builder().id(4L).title("TestPizza4").price(1500.0).build());
        userPizza.add(Pizza.builder().id(5L).title("TestPizza5").price(1600.0).build());

        return ResponseEntity.ok(new UserPizza(userPizza));
    }

    @GetMapping("/{pizzaId}")
    public ResponseEntity<?> getPizza(@PathVariable Long pizzaId){
        System.out.println("PizzaController.getPizza");
        //Long id = Long.parseLong(pizzaId);
        List<Pizza> userPizza = new ArrayList<>();

        userPizza.add(Pizza.builder().id(1L).title("TestPizza1").price(1200.0).description("GoodPizza1").build());
        userPizza.add(Pizza.builder().id(2L).title("TestPizza2").price(1300.0).description("GoodPizza1").build());
        userPizza.add(Pizza.builder().id(3L).title("TestPizza3").price(1400.0).description("GoodPizza1").build());
        userPizza.add(Pizza.builder().id(4L).title("TestPizza4").price(1500.0).description("GoodPizza1").build());
        userPizza.add(Pizza.builder().id(5L).title("TestPizza5").price(1600.0).description("GoodPizza1").build());

        for (Pizza pizza : userPizza){
            if (pizza.getId()==pizzaId) {
                return ResponseEntity.ok(pizza);
            }
        }

        return ResponseEntity.notFound().build();
    }
}
