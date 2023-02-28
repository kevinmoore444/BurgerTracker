package com.codingdojo.burger.tracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.burger.tracker.models.Burger;
import com.codingdojo.burger.tracker.repositories.BurgerRepository;

@Service
public class BurgerService {

	@Autowired
	private BurgerRepository burgerRepo;
	
	
	//get all 
	public List<Burger> allBurgers(){
		return burgerRepo.findAll();
	}
	
	
	//create 
	public Burger addBurger(Burger newBurger) {
		return burgerRepo.save(newBurger);
	}
	
	
	//find one
	
	public Burger oneBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepo.findById(id);
		if(optionalBurger.isPresent()) {
			return optionalBurger.get();
			
		}
		else {
			return null;
		}
	}
	
	
	//update
	public Burger updateBurger(Burger foundBurger) {
		return burgerRepo.save(foundBurger);
	}
	
	
	//delete
	public void deleteBurger(Long id) {
		burgerRepo.deleteById(id);
	}
	
	
	
}
