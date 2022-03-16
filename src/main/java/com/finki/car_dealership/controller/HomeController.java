package com.finki.car_dealership.controller;


import com.finki.car_dealership.model.Car;
import com.finki.car_dealership.model.Dealership;
import com.finki.car_dealership.service.CarBrandService;
import com.finki.car_dealership.service.CarService;

import com.finki.car_dealership.service.DealershipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private final CarService carService;
    private final DealershipService dealershipService;
    private final CarBrandService carBrandService;

    public HomeController(CarService carService, DealershipService dealershipService, CarBrandService carBrandService) {
        this.carService = carService;
        this.dealershipService = dealershipService;
        this.carBrandService = carBrandService;
    }

    /**
     * This method should use the "list.html" template to display all entities.
     * The method should be mapped on paths '/' and '/employees'.
     * The arguments that this method takes are optional and can be 'null'.
     *
     * @return The view "list.html".
     */
    @GetMapping({"/","/cars"})
    public String showList(Model model) {
        List<Car> cars;
        List<Dealership> dealershipList;

        dealershipList = this.dealershipService.findAll();
        cars = this.carService.findAll();
        model.addAttribute("cars",cars);
        model.addAttribute("dealerships",dealershipList);
        return "home.html";
    }

    /**
     * This method should display the "form.html" template.
     * The method should be mapped on path '/employees/add'.
     *
     * @return The view "form.html".
     */
    @GetMapping("/cars/add")
    public String showAdd(Model model) {
        model.addAttribute("dealerships",dealershipService.findAll());
        return "form.html";
    }
//
//    /**
//     * This method should display the "form.html" template.
//     * However, in this case all 'input' elements should be filled with the appropriate value for the entity that is updated.
//     * The method should be mapped on path '/employees/[id]/edit'.
//     *
//     * @return The view "form.html".
//     */
//    @GetMapping("/cars/{id}/dealership")
//    public String showDealership(@PathVariable Long id,Model model) {
//        Optional<Car> car=carService.findById(id);
//        model.addAttribute("emp",employee);
//        model.addAttribute("types",EmployeeType.values());
//        model.addAttribute("skills",skillService.listAll());
//        return "form.html";
//    }
//
//    /**
//     * This method should create an entity given the arguments it takes.
//     * The method should be mapped on path '/employees'.
//     * After the entity is created, the list of entities should be displayed.
//     *
//     * @return The view "list.html".
//     */
    @PostMapping("/cars")
    public String create(@RequestParam Long carBrand,
                         @RequestParam String model,
                         @RequestParam Long year,
                         @RequestParam Long price,
                         @RequestParam Long dealership) {
        this.carService.save(model, year,dealership , carBrand, price);
        return "redirect:/cars";
    }
//
//    /**
//     * This method should update an entity given the arguments it takes.
//     * The method should be mapped on path '/employees/[id]'.
//     * After the entity is updated, the list of entities should be displayed.
//     *
//     * @return The view "list.html".
//     */
//    @PostMapping("/employees/{id}")
//    public String update(@PathVariable Long id,
//                         @RequestParam String name,
//                         @RequestParam String email,
//                         @RequestParam String password,
//                         @RequestParam EmployeeType type,
//                         @RequestParam List<Long> skillId,
//                         @RequestParam String employmentDate) {
//        this.service.update(id, name, email, password, type, skillId, LocalDate.parse(employmentDate));
//        return "redirect:/employees";
//    }
//
//    /**
//     * This method should delete the entities that has the appropriate identifier.
//     * The method should be mapped on path '/employees/[id]/delete'.
//     * After the entity is deleted, the list of entities should be displayed.
//     *
//     * @return The view "list.html".
//     */
//    @PostMapping("/employees/{id}/delete")
//    public String delete(@PathVariable Long id) {
//        this.service.delete(id);
//        return "redirect:/employees";
//    }
}
