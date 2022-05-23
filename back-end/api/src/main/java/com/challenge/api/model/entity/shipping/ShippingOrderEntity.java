package com.challenge.api.model.entity.shipping;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "TB_SHIPPING_ORDER")
public class ShippingOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHO_ID")
    @SequenceGenerator(name="SHO_ID", allocationSize = 1)
    @Column(name = "SHO_ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SHO_SCMID")
    private ShippingCompany shippingCompany;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ShippingOrderEntity that = (ShippingOrderEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
