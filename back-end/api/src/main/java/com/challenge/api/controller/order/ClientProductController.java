package com.challenge.api.controller.order;

import com.challenge.api.model.entity.order.ClientProductOrderEntity;
import com.challenge.api.repository.order.ClientProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientProductController {
    @Autowired
    private ClientProductOrderRepository clientProductOrderRepository;

    public static final String ADD_PRODUCT_TO_CLIENT_ORDER = "addProductToClientOrder";
    @PostMapping("/v1/order/product")
    public ClientProductOrderEntity addProductToClientOrder(@RequestBody ClientProductOrderEntity clientProductOrderEntity) {
        return clientProductOrderRepository.save(clientProductOrderEntity);
    }
}
