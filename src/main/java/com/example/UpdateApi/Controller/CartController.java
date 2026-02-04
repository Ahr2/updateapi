package com.example.UpdateApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UpdateApi.Model.Cart;
import com.example.UpdateApi.Service.CartGrpcClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CartController {
/* 
    @Autowired
    private CartService cartService;

    @PutMapping("/updateproducts")
    public ResponseEntity<String> updateproducts(@RequestBody Cart cart){
        cartService.updateproducts(cart);

        return ResponseEntity.ok("Product updated successfully");
    }  */


    private CartGrpcClientService grpcClientService;

    @Autowired
    public void UpdateController(CartGrpcClientService grpcClientService) {
        this.grpcClientService = grpcClientService;
    }

    @PostMapping("/update/cart")
    public String updateCart() {
        return grpcClientService.updateCart(1, "Hemanth", 25);
    }


}
