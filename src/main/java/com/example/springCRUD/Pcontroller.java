package com.example.springCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Pcontroller {
    @Autowired
    private ProductService service;
//Add
    @PostMapping("/addproduct")
    public Product AddProduct(@RequestBody Product product){
        return service.save(product);
    }
    @PostMapping("/addproducts")
    public List<Product> AddProducts(@RequestBody List<Product> products){
        return service.saveALl(products);
    }
    //Get All
    @GetMapping("/products")
    public List<Product> Getall(){
        return service.getProducts();
    }
    @GetMapping("/product/{id}")
    public Product get(@PathVariable int id){
        return service.getProductById(id);
    }
    //delete
    @DeleteMapping("/delete")
    public String delete(@PathVariable int id){
        return service.deleteProduct(id);
    }

    //update
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }
}
