package com.codingdojo.burger.tracker.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="burgers") // The MySQL table name
public class Burger {

	//Attributes
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @NotNull(message="Must not be blank")
    @Size(min = 5, max = 50, message="Name must be at least 5 characters.")
    private String burgerName;
	
    @NotNull(message="Must not be blank")
    @Size(min = 5, max = 50, message="Name must be at least 5 characters.")
    private String restaurantName;
	
    @NotNull(message="Must not be blank")
    @Min(value=1, message="Rating must be between 1 and 5")
    @Max(value=5, message="Rating must be between 1 and 5")
    private Integer rating;
	
    @NotNull(message="Must not be blank")
    @Size(min = 5, max = 100, message="Description must be at least 5 characters.")
    private String description;
    
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
	
	
	//Constructors
	
    public Burger() {
    }



	public Burger(String burgerName, String restaurantName, Integer rating,
	String description) {
		this.burgerName = burgerName;
		this.restaurantName = restaurantName;
		this.rating = rating;
		this.description = description;
	}
	
	
    
    
    
	//Getters/Setters
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getBurgerName() {
		return burgerName;
	}



	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}



	public String getRestaurantName() {
		return restaurantName;
	}



	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}



	public Integer getRating() {
		return rating;
	}



	public void setRating(Integer rating) {
		this.rating = rating;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
	
	
}
