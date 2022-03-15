package com.finki.car_dealership.bootstrap;

import lombok.Getter;
import com.finki.car_dealership.model.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<CarBrand> carBrands = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Car> cars = new ArrayList<>();
    public static List<Dealership> dealerships = new ArrayList<>();
    public static List<Wishlist> wishlists = new ArrayList<>();


    @PostConstruct
    public void init () {
        carBrands.add(new CarBrand("Mazda", "Mazda Makedonija"));
        carBrands.add(new CarBrand("Renault", "Renault Makedonija"));
        carBrands.add(new CarBrand("Skoda", "Skoda Makedonija"));

        dealerships.add(new Dealership("Kadis", "Skopje"));
        dealerships.add(new Dealership("Mazda MK" , "Skopje"));
        dealerships.add(new Dealership("Volkswagen" , "Skopje"));

        cars.add(new Car("Demio", 1997L, dealerships.get(1), carBrands.get(0), 2000L ));
        cars.add(new Car("Clio", 2008L, dealerships.get(0), carBrands.get(1), 3500L ));
        cars.add(new Car("Octavia", 2010L, dealerships.get(2), carBrands.get(2), 7000L ));


    }


}
