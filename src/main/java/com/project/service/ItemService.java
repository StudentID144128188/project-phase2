package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Item;
import com.project.repository.ItemDao;

@Service
public class ItemService {
	
	@Autowired
	private ItemDao itemDao;
	
	public List<Item> getAllItems(){
		List<Item> items = new ArrayList<Item>();
		items = itemDao.findAll();
		return items;
	}
	
	public Item getItemById(String itemId){
		Optional<Item> item = itemDao.findById(itemId);
		if(item.isPresent()) {
			return item.get();
		}else {
			return null;
		}
	}
	
	public Item createItem(Item item) {
		itemDao.save(item);
		return item;
	}
	
	public void deleteItem(String itemId){
		itemDao.deleteById(itemId);
	}
	
	public Item updateItem(String itemId, Item item) {
		item.setId(itemId);
		itemDao.save(item);
		return item;
	}

	public List<Item> getAllItemsByType(String type) {
		List<Item> items = new ArrayList<Item>();
		items = itemDao.findAll();
		List<Item> results = items.stream()
			    .filter(e -> e.getType().toLowerCase().equals(type.toLowerCase()))
			    .collect(Collectors.toList()); 
		return results;
	}

	public List<Item> getAllItemsByTitle(String title) {
		List<Item> items = new ArrayList<Item>();
		items = itemDao.findAll();
		List<Item> results = items.stream()
			    .filter(e -> e.getTitle().toLowerCase().contains(title.toLowerCase()))
			    .collect(Collectors.toList()); 
		return results;
	}

	public List<Item> getAllItemsByTypeAndTitle(String type, String title) {
		List<Item> items = new ArrayList<Item>();
		items = itemDao.findAll();
		List<Item> results = items.stream()
			    .filter(e -> e.getTitle().toLowerCase().contains(title.toLowerCase()) || e.getType().toLowerCase().equals(type.toLowerCase()))
			    .collect(Collectors.toList()); 
		return results;
	}
	
	public List<Item> getItemsByBestseller(String isBestseller) {
		List<Item> items = new ArrayList<Item>();
		items = itemDao.findAll();
		List<Item> results = new ArrayList<Item>();
		if(isBestseller.equalsIgnoreCase("true")) {
			results = items.stream()
			    .filter(e -> e.isBestSeller() == true)
			    .collect(Collectors.toList()); 
		} else {
			results = items.stream()
				    .filter(e -> e.isBestSeller() == false)
				    .collect(Collectors.toList()); 
		}
		return results;
	}

	public List<Item> getItemsByAddress(String address) {
		List<Item> items = new ArrayList<Item>();
		items = itemDao.findAll();
		List<Item> results = items.stream()
			    .filter(e -> e.getAddress().toLowerCase().contains(address.toLowerCase()))
			    .collect(Collectors.toList()); 
		return results;
	}

	public List<Item> getAllItemsByContent(String content) {
		List<Item> items = new ArrayList<Item>();
		items = itemDao.findAll();
		List<Item> results = items.stream()
			    .filter(e -> e.getAddress().toLowerCase().contains(content.toLowerCase()) 
			    	|| e.getTitle().toLowerCase().contains(content.toLowerCase())
			    	|| e.getDescription().toLowerCase().equals(content.toLowerCase()))
			    .collect(Collectors.toList()); 
		return results;
	}

	public List<Item> getItemsByFeatures(String isFeatured) {
		List<Item> items = new ArrayList<Item>();
		items = itemDao.findAll();
		List<Item> results = new ArrayList<Item>();
		if(isFeatured.equalsIgnoreCase("true")) {
			results = items.stream()
			    .filter(e -> e.isFeatured() == true)
			    .collect(Collectors.toList()); 
		} else {
			results = items.stream()
				    .filter(e -> e.isFeatured() == false)
				    .collect(Collectors.toList()); 
		}
		return results;
	}

}
