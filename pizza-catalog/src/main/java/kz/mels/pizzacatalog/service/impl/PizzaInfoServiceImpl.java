package kz.mels.pizzacatalog.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kz.mels.pizzacatalog.model.Pizza;
import kz.mels.pizzacatalog.model.PizzaCatalog;
import kz.mels.pizzacatalog.model.UserPizza;
import kz.mels.pizzacatalog.service.PizzaInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PizzaInfoServiceImpl implements PizzaInfoService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand()
    public List<Pizza> getUserPizza() {
        //call pizza info data from pizza-info-microservice
        //get ratings for each pizza from pizza-rating microservice

        //RestTemplate restTemplate = new RestTemplate();
        UserPizza userPizza = restTemplate.getForObject("http://pizza-information-service/pizza/info/", UserPizza.class);

        return userPizza.getPizzas();
    }

    @Override
    @HystrixCommand()
    public Pizza getPizza(Long id) {
        Pizza pizza = restTemplate.getForObject("http://pizza-information-service/pizza/info/"+id, Pizza.class);

        return pizza;
    }



}
