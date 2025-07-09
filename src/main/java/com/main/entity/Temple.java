package com.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Temple {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   private String name;
   private String city;
   private String state;
   
   @Column(length = 2000)
   private String  description;
   
   private String imageUrl;
   
   public int getId() {
	return id;
}
   

public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public void setId(int id) {
	this.id = id;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getImageUrl() {
	return imageUrl;
}

public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}


   

}
