package com.codingdojo.burger.tracker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.burger.tracker.models.Burger;
import com.codingdojo.burger.tracker.services.BurgerService;

@Controller
public class HomeController {

	@Autowired
	private BurgerService burgerService;
	
	//Get all 
	@GetMapping("/burgers")
	public String dashboardPage(Model model, @ModelAttribute("burger") Burger burger) {
		List<Burger> allBurgers = burgerService.allBurgers();
		model.addAttribute("burgerList", allBurgers);
		return "dashboard.jsp";
	}
	
	
	//Create One
    @PostMapping("/burgers")
    public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
        if (result.hasErrors()) {
            return "dashboard.jsp";
        } 
        else {
            burgerService.addBurger(burger);
            return "redirect:/burgers";
        }
    }
	
	
    //Edit One
    @GetMapping("/burgers/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Burger burger = burgerService.oneBurger(id);
        model.addAttribute("burger", burger);
        return "edit.jsp";
    }
    
    
    @PostMapping("/burgers/{id}")
    public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            burgerService.updateBurger(burger);
            return "redirect:/burgers";
        }
    }
    
    
    
	
}
