package com.challenge.api.model.entity.order;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TB_CLIENT_ORDER")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
//TODO: Add history of order
public class ClientOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COD_ID")
    @SequenceGenerator(name = "COD_ID", allocationSize = 1)
    @Column(name = "COR_ID", nullable = false)
    private Long id;

    @Column(name = "COR_TOTAL")
    private Double total;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<ClientProductOrderEntity> orderProductEntities = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClientOrderEntity that = (ClientOrderEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
