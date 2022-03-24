package com.finki.car_dealership.controller;

import com.finki.car_dealership.model.Wishlist;
import com.finki.car_dealership.model.User;
import com.finki.car_dealership.model.service.WishlistService;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/wishlist")
    public String getWishlistPage(@RequestParam(required = false) String error,
                                  HttpServletRequest req,
                                  Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        String username = req.getRemoteUser();
        Wishlist wishlist = this.wishlistService.getWishlist(username);
        model.addAttribute("cars", this.wishlistService.listAllCarsInWishlist(wishlist.getId()));
        model.addAttribute("bodyContent", "wishlist");
        return "wishlist";
    }

    @GetMapping("/add-car/{id}")
    public String addCarToWishlist(@PathVariable Long id, HttpServletRequest req, Authentication authentication) {
            User user = (User) authentication.getPrincipal();
            this.wishlistService.addCarToWishlist(user.getUsername(), id);
            return "redirect:/wishlist";
    }
    @GetMapping("/wishlist/{id}/delete")
    public String removeCarToWishlist(@PathVariable Long id, HttpServletRequest req, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        this.wishlistService.removeCarToWishlist(user.getUsername(), id);
        return "redirect:/wishlist";
    }
}
