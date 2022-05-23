package com.challenge.api.controller.order;

import com.challenge.api.model.entity.order.ClientOrderEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientOrderController {
    @GetMapping("/v1/order/{id}")
    public ClientOrderEntity getReferenceById(@PathVariable("id") ClientOrderEntity clientOrderEntity) {
        return clientOrderEntity;
    }
}
