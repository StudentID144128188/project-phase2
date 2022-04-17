package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Item;
import com.project.service.ItemService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/items")
	public ResponseEntity<List<Item>> getAllItems(@RequestParam(name = "type", required = false) String type,
			@RequestParam(name = "title", required = false) String title
			){
		try {
			List<Item> items = new ArrayList<Item>();
			if(type == null && title == null ) {
				items = itemService.getAllItems();
			} else if (type != null && title == null ){
				items = itemService.getAllItemsByType(type);
			} else if (type == null && title != null ) {
				items = itemService.getAllItemsByTitle(title);
			} else {
				items = itemService.getAllItemsByTypeAndTitle(type,title);
			} 
		    if (items.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		    return new ResponseEntity<>(items, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
		
	}
	
	@GetMapping("/items/bestsellers")
	public ResponseEntity<List<Item>> getItemsByBestseller(@RequestParam(name = "isBestseller", required = true) String isBestseller){
		try {
			List<Item> items = new ArrayList<Item>();
			items = itemService.getItemsByBestseller(isBestseller);
		    if (items.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		    return new ResponseEntity<>(items, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
	
	@GetMapping("/items/properties")
	public ResponseEntity<List<Item>> getItemsByFeatures(@RequestParam(name = "isFeatured", required = true) String isFeatured){
		try {
			List<Item> items = new ArrayList<Item>();
			items = itemService.getItemsByFeatures(isFeatured);
		    if (items.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		    return new ResponseEntity<>(items, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
	
	@GetMapping("/items/search/address/{address}")
	public ResponseEntity<List<Item>> getItemsByAddress(@PathVariable String address){
		try {
			List<Item> items = new ArrayList<Item>();
			items = itemService.getItemsByAddress(address);
		    if (items.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		    return new ResponseEntity<>(items, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
	@GetMapping("/items/search/title/{title}")
	public ResponseEntity<List<Item>> getItemsByTitle(@PathVariable String title){
		try {
			List<Item> items = new ArrayList<Item>();
			items = itemService.getAllItemsByTitle(title);
		    if (items.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		    return new ResponseEntity<>(items, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
	@GetMapping("/items/search/content/{content}")
	public ResponseEntity<List<Item>> getItemsByContent(@PathVariable String content){
		try {
			List<Item> items = new ArrayList<Item>();
			items = itemService.getAllItemsByContent(content);
		    if (items.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		    return new ResponseEntity<>(items, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
	
	@GetMapping("/items/{itemId}")
	public ResponseEntity<Item> getItemById(@PathVariable String itemId){
		try {
			Item item = itemService.getItemById(itemId);
		    if (null == item) {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    } else {
		    	return new ResponseEntity<>(item, HttpStatus.OK);
		    }
		  } catch (Exception e) {
		    return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		  }
	}
	
	@PostMapping("/items")
	public ResponseEntity<Item> createItem(@Valid @RequestBody Item item) {
		  try {
			  Item new_item = itemService.createItem(item);
		    return new ResponseEntity<>(new_item, HttpStatus.CREATED);
		  } catch (Exception e) {
		    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		  }
		}
	
	@PutMapping("/items/{itemId}")
	public ResponseEntity<Item> updateItem(@PathVariable String itemId, @Valid @RequestBody Item item) {
		 try {
			Item temp = itemService.getItemById(itemId);
		 	Item new_item = itemService.updateItem(itemId, item);
		 	if(null != temp) {
		 		return new ResponseEntity<>(new_item, HttpStatus.OK);	
		 	} else {
		 		return new ResponseEntity<>(new_item, HttpStatus.CREATED);	
		 	}
		 } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			  }
	}
	
	@DeleteMapping("/items/{itemId}")
	public ResponseEntity<String> deleteItem(@PathVariable String itemId) {
	  try {
		  Item temp = itemService.getItemById(itemId);
		  itemService.deleteItem(itemId);
		 if(null != temp) {
			 	return new ResponseEntity<>("Item has been deleted", HttpStatus.OK);
		 } else {
		 		return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);	
		 	}
	  } catch (Exception e) {
	    return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
	  }
	}
}
