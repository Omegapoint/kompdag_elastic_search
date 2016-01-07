package se.omegapoint.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BRAND", uniqueConstraints = @UniqueConstraint(name = "UQ_BRAND_BRAND_NAME", columnNames = "BRAND_NAME"))
public class Brand extends AbstractEntity {

    @Column(name = "BRAND_NAME", nullable = false, unique = true, insertable = false, updatable = false)
    private String brandName;

    @Column(name = "ESTABLISHED_YEAR", nullable = false, unique = false, insertable = false, updatable = false)
    private Long establishedYear;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand", orphanRemoval = false)
    private Set<Article> articles;

}
