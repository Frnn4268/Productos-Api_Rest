package com.example.demo.Controladores;

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

import com.example.demo.Entidades.Product;
import com.example.demo.Servicios.Product_Services;

@RestController
@RequestMapping("/products")
public class Product_Controller {
	
	@Autowired
	Product_Services Productos;
	
	@GetMapping()
	public List<Product> Listar_Producto(){
		List<Product> lista = Productos.List_Products();
		return lista;
	}
	
	@GetMapping("/{id}")
	public Product Buscar_Producto(@PathVariable Long id) {
		Product estudiante = Productos.Search_Products(id);
		return estudiante;
	}
	
	@PostMapping
	public void Crea_Producto(@RequestBody Product product) {
		Productos.Create_Products(product);
	}
	
	@DeleteMapping("/{id}")
	public void Eliminar_Producto(@PathVariable Long id) {
		Productos.Delete_Products(id);
	}
	
	@PutMapping("/{id}")
	public void Actualizar_Productos(@PathVariable Long id,@RequestBody   Product product) {
		Productos.Update_Products(id, product);
	}
	
}
