package com.example.springCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    // i write all get,post,put,and update method
    //post
    public Product save(Product product){
        return productRepo.save(product);
    }
    //for save all
    public List<Product> saveALl(List<Product> products){
        return productRepo.saveAll(products);
    }
    //get
    //to get all
    public List<Product> getProducts(){
        return productRepo.findAll();
    }
    //to get one
    public Product getProductById(int id){
        return productRepo.findById(id).orElse(null);
    }
    //delete
    public String deleteProduct(int id){
        productRepo.deleteById(id);
        return "Poducted is deleted";
    }
    //update
    public Product updateProduct(Product product){
        Product existinProduct=productRepo.findById(product.getId()).orElse(null);
        existinProduct.setId(product.getId());
        existinProduct.setName(product.getName());
        return productRepo.save(existinProduct);
    }


}
