package com.challenge.api.repository.product;

import com.challenge.api.model.entity.product.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, Long> {
    Slice<ProductEntity> findAllByValue(double value, Pageable pageable);
}