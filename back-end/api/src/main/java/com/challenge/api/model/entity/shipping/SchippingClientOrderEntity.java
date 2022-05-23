package com.challenge.api.model.entity.shipping;

import com.challenge.api.model.entity.order.ClientOrderEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "TB_SHIPPING_CLIENT_ORDER")
public class SchippingClientOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCO_ID")
    @SequenceGenerator(name = "SCO_ID", allocationSize = 1)
    @Column(name = "SCO_ID", nullable = false)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "SCO_SHOID")
    private ShippingOrderEntity shippingOrder;
    
    @ManyToOne
    @JoinColumn(name = "SCO_CORID")
    private ClientOrderEntity orderClient;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SchippingClientOrderEntity that = (SchippingClientOrderEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
