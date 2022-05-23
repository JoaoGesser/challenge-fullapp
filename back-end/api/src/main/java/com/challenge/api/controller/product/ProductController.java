package com.challenge.api.controller.product;

import com.challenge.api.controller.order.ClientProductController;
import com.challenge.api.model.entity.product.ProductEntity;
import com.challenge.api.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.util.Streamable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public Slice<ProductEntity> findAllProducts(@RequestParam(required = false, name = "page") Integer page, @PageableDefault(value = 5, page = 0) Pageable pageable) {
        Slice<ProductEntity> products = productRepository.findAll(pageable);
        for (ProductEntity product : products) {
            product.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientProductController.class).addProductToClientOrder(null)).slash(product.getId()).withRel(LinkRelation.of("addProductToClientOrder")));
        }
        return products;
    }
}
