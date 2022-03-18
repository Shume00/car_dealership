package com.finki.car_dealership.controller;

import com.finki.car_dealership.model.Car;
import com.finki.car_dealership.model.CarBrand;
import com.finki.car_dealership.model.Dealership;
import com.finki.car_dealership.model.service.CarBrandService;
import com.finki.car_dealership.model.service.DealershipService;
import com.finki.car_dealership.model.service.CarService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class CarController {

    private final CarService carService;
    private final CarBrandService carBrandService;
    private final DealershipService dealershipService;
    public CarController(CarService carService,
                         CarBrandService carBrandService,
                         DealershipService dealershipService) {
        this.carService = carService;
        this.carBrandService = carBrandService;
        this.dealershipService = dealershipService;
    }


    @GetMapping
    public String getProductPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Car> cars = this.carService.findAll();
        model.addAttribute("cars", cars);
        model.addAttribute("bodyContent", "products");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.carService.deleteById(id);
        return "redirect:/cars";
    }

    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {
        if (this.carService.findById(id).isPresent()) {
            Car car = this.carService.findById(id).get();
            List<Dealership> dealerships= this.dealershipService.findAll();
            List<CarBrand> carBrands = this.carBrandService.listCarBrands();
            model.addAttribute("dealerships", dealerships);
            model.addAttribute("carBrands", carBrands);
            model.addAttribute("car", car);
            model.addAttribute("bodyContent", "add-product");
            return "master-template";
        }
        return "redirect:/products?error=ProductNotFound";
    }

    @GetMapping("/add-form")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addProductPage(Model model) {
        List<Dealership> dealerships = this.dealershipService.findAll();
        List<CarBrand> carBrands = this.carBrandService.listCarBrands();
        model.addAttribute("dealerships", dealerships);
        model.addAttribute("carBrands", carBrands);
        model.addAttribute("bodyContent", "add-product");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveProduct(
            @RequestParam(required = false) Long id,
            @RequestParam String model,
            @RequestParam Long year,
            @RequestParam Long dealership,
            @RequestParam Long carBrand,
            @RequestParam Long price) {
        if (id != null) {
            this.carService.edit(id,model,year,dealership,carBrand,price);
        } else {
            this.carService.save(model,year,dealership,carBrand,price);
        }
        return "redirect:/products";
    }
}

