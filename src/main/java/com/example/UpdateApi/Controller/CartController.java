package com.example.UpdateApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UpdateApi.Model.Cart;
import com.example.UpdateApi.Service.CartService;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PutMapping("/updateproducts")
    public ResponseEntity<String> updateproducts(@RequestBody Cart cart){
        cartService.updateproducts(cart);

        return ResponseEntity.ok("Product updated successfully");
    }
}
