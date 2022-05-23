package com.challenge.api.model.entity.order;

import com.challenge.api.model.entity.product.ProductEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TB_CLIENT_PRODUCT_ORDER")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ClientProductOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CPO_ID")
    @SequenceGenerator(name = "CPO_ID", allocationSize = 1)
    @Column(name = "CPO_ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CPO_CORID")
    private ClientOrderEntity order;

    @ManyToOne
    @JoinColumn(name = "CPO_PROID")
    private ProductEntity product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClientProductOrderEntity that = (ClientProductOrderEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
