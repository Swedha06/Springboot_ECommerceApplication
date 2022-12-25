package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ecommerce {
@Id 
@GeneratedValue(strategy=GenerationType.AUTO)

private int id;
private int productId;
private String productName;
private String description;
private String quantity;
private String price;
private String type;

ecommerce() {}

ecommerce(int productId,String productName, String description, String quantity, String price, String type)
{
	this.setProductId(productId);
	this.setProductName(productName);
	this.setDescription(description);
	this.setQuantity(quantity);
	this.setPrice(price);
	this.setType(type);
}
public int getProductId()
{
	return productId;
}
public void setProductId(int productId)
{
	this.productId=productId;
}
public String getProductName()
{
	return productName;
}
public void setProductName(String productName)
{
	this.productName=productName;
}
public String getDescription()
{
	return description;
}
public void setDescription(String description)
{
	this.description=description;
}
public String getQuantity()
{
	return quantity;
}
public void setQuantity(String quantity)
{
	this.quantity=quantity;
}
public String getPrice()
{
	return price;
}
public void setPrice(String price)
{
	this.price=price;
}
public String getType()
{
	return type;
}
public void setType(String type)
{
	this.type=type;
}
}

