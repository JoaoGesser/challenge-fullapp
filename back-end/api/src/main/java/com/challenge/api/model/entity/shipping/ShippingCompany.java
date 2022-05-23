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
@Table(name = "TB_SHIPPING_COMPANY")
public class ShippingCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCM_ID")
    @SequenceGenerator(name = "SCM_ID", allocationSize = 1)
    @Column(name = "SCM_ID", nullable = false)
    private Long id;

    @Column(name = "SCM_NAME")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ShippingCompany that = (ShippingCompany) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
