package com.example.controllers;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Product;
import com.example.models.PaymentType;
import com.example.models.Person;
import com.example.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class ProductController {
	
	private ProductService tService;
	
	@GetMapping("/")
	public List<Product> getProducts(){
		
			return tService.getAllProducts();
		}
	
	@GetMapping("/{category}")
	public List<Product> getProductsByCategory(@PathVariable int category){
		    
			return tService.getProductsByCategory(category);
		}
	
	@PostMapping("/cart")
	public Person register(@RequestBody LinkedHashMap<String, String> body) {
		System.out.println("fsfsfdsfsfffsffdfsdd   "+body.toString());
		return tService.addToCart(body.get("name"), body.get("email"), body.get("password"));
	}
		
	}
