package com.example.UpdateApi.Service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.firstapi.grpc.UpdateCartRequestOrBuilder;
import com.example.UpdateApi.Model.Cart;
import com.example.firstapi.grpc.CartServiceGrpc;
import com.example.firstapi.grpc.UpdateCartRequest;
import com.example.firstapi.grpc.UpdateCartResponse;

import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class CartGrpcClientService {
    
/*     private final RestTemplate restTemplate = new RestTemplate();

    public String updateproducts(Cart cart) {

    HttpEntity<Cart> request = new HttpEntity<>(cart);

    ResponseEntity<String> response = restTemplate.exchange(
        "https://firstapi-9.onrender.com/updateproduct",
        HttpMethod.PUT,
        request,
        String.class
    );

    return response.getBody();
    }
*/
    
   // Name must match application.properties
    @GrpcClient("firstapi")
    private CartServiceGrpc.CartServiceBlockingStub cartStub;

    public String updateCart(int id, String name, int age) {

        UpdateCartRequest request =
                UpdateCartRequest.newBuilder()
                        .setId(id)
                        .setName(name)
                        .setAge(age)
                        .build();

        UpdateCartResponse response = cartStub.updateCart(request);
        return response.getMessage();
    }
}
