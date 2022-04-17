package com.project.entity;

import java.util.Arrays;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
public class Item {
	@Id
	 private String id;
	
	@NotEmpty(message = "The title is required.")
	 private String title;
	
	@NotEmpty(message = "The description is required.")
	 private String description;
	
	@NotEmpty(message = "The type is required.")
	 private String type;
	
	@NotEmpty(message = "The price is required.")
	 private String price;
	
	@NotEmpty(message = "The images are required.")
	 private String[] image;
	
	@NotEmpty(message = "The address are required.")
	 private String address;
	
	@NotEmpty(message = "The coord are required.")
	 private String[] coord;
	
	 private boolean bestSeller;
	 private boolean featured;
	 
	 @NotNull(message = "The amenities are required.")
	 private Amenity amenities;
	 
	 @NotNull(message = "The rules are required.")
	 private Rule rules;
	 
	 @NotNull (message = "The star is required.")
     private int star;
	 
	 @NotNull (message = "The comments are required.")
	 private Comment comments;
	 
	public Item() {
		super();
	}

	public Item(String id, String title, String description, String type, String price, String[] image, String address,
			String[] coord, boolean bestSeller, boolean featured, Amenity amenities, Rule rules, int star,
			Comment comments) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.type = type;
		this.price = price;
		this.image = image;
		this.address = address;
		this.coord = coord;
		this.bestSeller = bestSeller;
		this.featured = featured;
		this.amenities = amenities;
		this.rules = rules;
		this.star = star;
		this.comments = comments;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String[] getImage() {
		return image;
	}

	public void setImage(String[] image) {
		this.image = image;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String[] getCoord() {
		return coord;
	}

	public void setCoord(String[] coord) {
		this.coord = coord;
	}

	public boolean isBestSeller() {
		return bestSeller;
	}

	public void setBestSeller(boolean bestSeller) {
		this.bestSeller = bestSeller;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

	public Amenity getAmenities() {
		return amenities;
	}

	public void setAmenities(Amenity amenities) {
		this.amenities = amenities;
	}

	public Rule getRules() {
		return rules;
	}

	public void setRules(Rule rules) {
		this.rules = rules;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public Comment getComments() {
		return comments;
	}

	public void setComments(Comment comments) {
		this.comments = comments;
	}
	
	public boolean isEmpty() {
		return (this.type.isBlank() || this.type == null);
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", description=" + description + ", type=" + type + ", price="
				+ price + ", image=" + Arrays.toString(image) + ", address=" + address + ", coord="
				+ Arrays.toString(coord) + ", bestSeller=" + bestSeller + ", featured=" + featured + ", amenities="
				+ amenities + ", rules=" + rules + ", star=" + star + ", comments=" + comments + "]";
	}
   
	 
}
