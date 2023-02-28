package com.codingdojo.burger.tracker.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.burger.tracker.models.Burger;
import com.codingdojo.burger.tracker.services.BurgerService;

@RestController
@RequestMapping("/api")
public class APIController {
	
	private final BurgerService burgerService;

	
	public APIController(BurgerService burgerService) {
		this.burgerService = burgerService;
	}	
	
	
	//get all
	@GetMapping("/burgers")
	public List<Burger> getAllBurgers(){
		return burgerService.allBurgers();
	}
	
	
	//create 
	@PostMapping("/burgers")
	public Burger createBurger( 
		@RequestParam("burgerName") String burgerName,
		@RequestParam("restaurantName") String restaurantName,
		@RequestParam("rating") Integer rating,
		@RequestParam("description") String description

		) {
		Burger newBurger = new Burger(burgerName, restaurantName, rating, description);
		return burgerService.addBurger(newBurger);
	} 
	
	
	//get one 
	@GetMapping("/burgers/{id}")
	public Burger getOneBurger(@PathVariable("id")Long id) {
		return burgerService.oneBurger(id);
	}
	
	
	//update -- findOne & create
	@PutMapping("/burgers/{id}") 
	public Burger editBurgerProcess(
			@PathVariable("id")Long id,
			@RequestParam("burgerName") String burgerName,
			@RequestParam("restaurantName") String restaurantName,
			@RequestParam("rating") Integer rating,
			@RequestParam("description") String description
			) 
		{
		Burger foundBurger = burgerService.oneBurger(id);
		foundBurger.setBurgerName(burgerName);
		foundBurger.setRestaurantName(restaurantName);
		foundBurger.setRating(rating);
		foundBurger.setDescription(description);
		return burgerService.updateBurger(foundBurger);
		}
	
	//delete 
	@DeleteMapping("/burgers/{id}")
	public void deleteBurger(@PathVariable("id")Long id) {
		burgerService.deleteBurger(id);
	}
	
	
	
	
}
