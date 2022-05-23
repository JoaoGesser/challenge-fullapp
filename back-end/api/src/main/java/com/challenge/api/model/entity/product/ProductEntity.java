package com.challenge.api.model.entity.product;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TB_PRODUCT")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ProductEntity extends RepresentationModel<ProductEntity> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRO_ID")
    @SequenceGenerator(name = "PRO_ID", allocationSize = 1)
    @Column(name = "PRO_ID", nullable = false)
    private Long id;

    @Column(name = "PRO_NAME", unique = true)
    private String name;

    @Column(name = "PRO_VALUE")
    private Double value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductEntity that = (ProductEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
