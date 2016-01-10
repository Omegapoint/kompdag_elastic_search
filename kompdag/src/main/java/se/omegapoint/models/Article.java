package se.omegapoint.models;

import se.omegapoint.converters.LocalDateSqlDateConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "ARTICLE", uniqueConstraints = @UniqueConstraint(name = "UQ_ARTICLE_DESC_COLOR", columnNames = {"DESCRIPTION", "COLOR"}))
public class Article extends  AbstractEntity {

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "COLOR", nullable = true)
    private String color;

    @Column(name = "WEIGHT", nullable = true)
    private Long weight;

    @Column(name = "WEIGHT_UOM", nullable = false)
    private String weightUom;

    @Column(name = "SELLING_START_DATE", nullable = false)
    @Convert(converter = LocalDateSqlDateConverter.class)
    private LocalDate sellingStartDate;

    @Column(name = "PROGRAMMER_ID", nullable = false)
    private Long programmerId;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private Brand brand;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "article", orphanRemoval = true, targetEntity = Uda.class)
    private Set<Uda> udas;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, targetEntity = Supplier.class)
    @JoinTable(name = "ARTICLE_SUPPLIER",
        joinColumns = {@JoinColumn(name = "ARTICLE_ID", referencedColumnName = "ID", nullable = false)},
        inverseJoinColumns = {@JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "ID", nullable = false)})
    private Set<Supplier> suppliers;


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public Long getWeight() {
        return weight;
    }
    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getWeightUom() {
        return weightUom;
    }
    public void setWeightUom(String weightUom) {
        this.weightUom = weightUom;
    }

    public LocalDate getSellingStartDate() {
        return sellingStartDate;
    }
    public void setSellingStartDate(LocalDate sellingStartDate) {
        this.sellingStartDate = sellingStartDate;
    }

    public Long getProgrammerId() {
        return programmerId;
    }
    public void setProgrammerId(Long programmerId) {
        this.programmerId = programmerId;
    }

    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<Uda> getUdas() {
        return udas;
    }
    public void setUdas(Set<Uda> udas) {
        this.udas = udas;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }
    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}
