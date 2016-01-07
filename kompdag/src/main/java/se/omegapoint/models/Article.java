package se.omegapoint.models;

import se.omegapoint.converters.LocalDateSqlDateConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "ARTICLE", uniqueConstraints = @UniqueConstraint(name = "UQ_ARTICLE_DESC_COLOR", columnNames = {"DESCRIPTION", "COLOR"}))
public class Article extends  AbstractEntity {

    @Column(name = "DESCRIPTION", nullable = false, insertable = false, updatable = false)
    private String description;

    @Column(name = "COLOR", nullable = false, insertable = false, updatable = false)
    private String color;

    @Column(name = "WEIGHT", nullable = false, insertable = false, updatable = false)
    private Long weight;

    @Column(name = "WEIGHT_UOM", nullable = false, insertable = false, updatable = false)
    private String weightUom;

    @Column(name = "SELLING_START_DATE", nullable = false, insertable = false, updatable = false)
    @Convert(converter = LocalDateSqlDateConverter.class)
    private LocalDate sellingStartDate;

    @Column(name = "PROGRAMMER_ID", nullable = false, insertable = false, updatable = false)
    private Long programmerId;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    @JoinColumn(name = "BRAND_ID", nullable = false, insertable = false, updatable = false)
    private Brand brand;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "article", orphanRemoval = true, targetEntity = Uda.class)
    private Set<Uda> udas;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, targetEntity = Supplier.class)
    @JoinTable(name = "ARTICLE_SUPPLIER",
        joinColumns = {@JoinColumn(name = "ARTICLE_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)},
        inverseJoinColumns = {@JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)})
    private Set<Supplier> suppliers;

}
