package com.example.UpdateApi.Service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.UpdateApi.Model.Cart;

@Service
public class CartService {
    
    private final RestTemplate restTemplate = new RestTemplate();

    public String updateproducts(Cart cart) {

    HttpEntity<Cart> request = new HttpEntity<>(cart);

    ResponseEntity<String> response = restTemplate.exchange(
        "http://localhost:8081/updateproduct",
        HttpMethod.PUT,
        request,
        String.class
    );

    return response.getBody();
    }
}
