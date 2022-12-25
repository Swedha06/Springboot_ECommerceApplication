package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class operations {
@Autowired repository ob;
@PostMapping("/add")
public String save(@RequestBody ecommerce ecommerce1)
{
	ecommerce w= new ecommerce();
	int id=ecommerce1.getProductId();
	String productName=ecommerce1.getProductName();
	String description=ecommerce1.getDescription();
	String quantity=ecommerce1.getQuantity();
	String price=ecommerce1.getPrice();
	String type=ecommerce1.getType();
	
	w.setProductId(id);
	w.setProductName(productName);
	w.setDescription(description);
	w.setQuantity(quantity);
	w.setPrice(price);
	w.setType(type);
	
	ecommerce first = new ecommerce(id,productName,description,quantity,price,type);
	ob.save(first);
	return "Products Added successfully";
}

@GetMapping("/ecommerce")
public List<ecommerce> getAllproducts()
{
	return ob.findAll();
}

@GetMapping("ecommerce/{id}")
public List<ecommerce> getProductById(@PathVariable("id") int id)
{
	return ob.findById(id);
}

@PutMapping("/update/{id}")
public String update(@RequestBody ecommerce x,@PathVariable("id") int id)
{
	int productId1=x.getProductId();
	String productName=x.getProductName();
	String description=x.getDescription();
	String quantity=x.getQuantity();
	String price=x.getPrice();
	String type=x.getType();
	ob.update(productId1,productName,description,quantity,price,type,id);
	return "Successfully updated";
}

@DeleteMapping("delete/{id}")
public String deleteById(@PathVariable("id") int id)
{
	ob.deleteAllByIdInBatch(id);
	return "Products deleted successfully";
}
}


