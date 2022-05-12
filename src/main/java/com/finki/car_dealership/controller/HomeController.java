package com.finki.car_dealership.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.finki.car_dealership.model.Car;
import com.finki.car_dealership.model.Dealership;
import com.finki.car_dealership.model.User;
import com.finki.car_dealership.model.Wishlist;
import com.finki.car_dealership.model.service.CarBrandService;
import com.finki.car_dealership.model.service.CarService;

import com.finki.car_dealership.model.service.DealershipService;
import com.finki.car_dealership.model.service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    private final CarService carService;
    private final DealershipService dealershipService;
    private final CarBrandService carBrandService;
    private final WishlistService wishlistService;

    public HomeController(CarService carService, DealershipService dealershipService, CarBrandService carBrandService, WishlistService service, WishlistService wishlistService) {
        this.carService = carService;
        this.dealershipService = dealershipService;
        this.carBrandService = carBrandService;
        this.wishlistService = wishlistService;
    }
    
    @GetMapping({"/","/home"})
    public String showHome(Model model) {
        return "home.html";
    }


    @GetMapping({"/cars"})
    public String showList(Model model) {
        List<Car> cars;
        List<Dealership> dealershipList;

        dealershipList = this.dealershipService.findAll();
        cars = this.carService.findAll();
        model.addAttribute("cars",cars);
        model.addAttribute("dealerships",dealershipList);
        return "cars.html";
    }

    @GetMapping({"/dealerships"})
    public String showDealerships(Model model) {
        List<Dealership> dealerships;
        dealerships = this.dealershipService.findAll();
        model.addAttribute("dealerships",dealerships);
        return "dealerships.html";
    }

    @GetMapping({"/dealerships/{id}"})
    public String showDealershipwithCars(
            @PathVariable Long id,
            Model model){
        List<Car> cars;
        cars = this.carService.findByDealershipId(id);
        model.addAttribute("cars",cars);
        return "dealership.html";
    }

    @GetMapping("/cars/add")
    public String showAdd(Model model) {
        model.addAttribute("dealerships",dealershipService.findAll());
        model.addAttribute("carBrands",carBrandService.listCarBrands());
        return "form.html";
    }

    @GetMapping("cars/{id}/edit")
    public String editCar(@PathVariable Long id, Model model) {

            Car car = this.carService.findById(id).get();
            List<Dealership> dealershipList= this.dealershipService.findAll();
            model.addAttribute("car",car);
            model.addAttribute("dealerships",dealershipList);
            model.addAttribute("carBrands",carBrandService.listCarBrands());
            return "form.html";

    }

    @PostMapping("/cars")
    public String create(@RequestParam Long carBrand,
                         @RequestParam String model,
                         @RequestParam Long year,
                         @RequestParam Long price,
                         @RequestParam Long dealership) {
        this.carService.save(model, year,dealership , carBrand, price);
        return "redirect:/cars";
    }

    @PostMapping("/cars/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam Long carBrand,
                         @RequestParam String model,
                         @RequestParam Long year,
                         @RequestParam Long price,
                         @RequestParam Long dealership) {
        this.carService.edit(id, model, year,dealership , carBrand, price);
        return "redirect:/cars";
    }

    @PostMapping("/cars/{id}/delete")
    public String delete(@PathVariable Long id) {
        this.carService.deleteById(id);
        return "redirect:/cars";
    }
}
