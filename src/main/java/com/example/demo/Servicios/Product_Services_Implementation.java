package com.example.demo.Servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.demo.Entidades.Product;

@Service
public class Product_Services_Implementation implements Product_Services{
	
	private static AtomicLong sequence = new AtomicLong();
	private static List<Product> lista = new ArrayList<Product>() {{
		add(new Product(sequence.incrementAndGet(),"Producto","Samsung","Descripción1","300"));
		add(new Product(sequence.incrementAndGet(),"Producto","Apple","Descripción2","200"));
		add(new Product(sequence.incrementAndGet(),"Producto","Razer","Descripción3","100"));
	}};

	public List<Product> List_Products() {
		return lista;
	}

	@Override
	public Product Search_Products(long iD) {
		for (Product e: lista) {
			if (e.getID().equals(iD))
				return e;
		}
		return null;
	}

	@Override
	public void Create_Products(Product product) {
		product.setID(sequence.incrementAndGet());
		lista.add(product);
	}

	@Override
	public void Delete_Products(long iD) {
		for (Product e: lista) {
			if (e.getID().equals(iD))
				lista.remove(e);
		}
	}

	@Override
	public void Update_Products(long iD, Product product) {
		int id_value = (int) iD-1;	
		product.setID(iD);
		lista.set(id_value, product);
	}
}
