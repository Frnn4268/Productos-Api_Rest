package com.example.demo.Servicios;

import java.util.List;

import com.example.demo.Entidades.Product;

public interface Product_Services {
	public List<Product> List_Products();
	public Product Search_Products(long iD);
	public void Create_Products(Product product);
	public void Delete_Products(long iD);
	public  void Update_Products (long iD, Product product);
}
