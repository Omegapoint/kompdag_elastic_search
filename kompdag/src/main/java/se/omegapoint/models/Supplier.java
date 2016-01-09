package se.omegapoint.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SUPPLIER", uniqueConstraints = @UniqueConstraint(name = "UQ_SUPPLIER_SUP_NAME", columnNames = "SUPPLIER_NAME"))
public class Supplier extends AbstractEntity {

    @Column(name = "SUPPLIER_NAME", nullable = false, unique = true, insertable = false, updatable = false)
    private String supplierName;

    @Column(name = "SUPPLIER_STATUS", nullable = false, insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private Status supplierStatus;

    @Column(name = "LEAD_DELIVERY_TIME")
    private Long leadDeliveryTime;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Article.class)
    private Set<Article> articles;

    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Status getSupplierStatus() {
        return supplierStatus;
    }
    public void setSupplierStatus(Status supplierStatus) {
        this.supplierStatus = supplierStatus;
    }

    public Long getLeadDeliveryTime() {
        return leadDeliveryTime;
    }
    public void setLeadDeliveryTime(Long leadDeliveryTime) {
        this.leadDeliveryTime = leadDeliveryTime;
    }

    public Set<Article> getArticles() {
        return articles;
    }
    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
