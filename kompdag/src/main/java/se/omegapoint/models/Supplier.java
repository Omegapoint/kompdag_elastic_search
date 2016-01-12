package se.omegapoint.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SUPPLIER", uniqueConstraints = @UniqueConstraint(name = "UQ_SUPPLIER_SUP_NAME", columnNames = "SUPPLIER_NAME"))
public class Supplier extends AbstractEntity {

    @Column(name = "SUPPLIER_NAME", nullable = false, unique = true)
    private String supplierName;

    @Column(name = "LEAD_DELIVERY_TIME", nullable = false)
    private Long leadDeliveryTime;

    @ManyToMany(mappedBy = "suppliers")
    private Set<Article> articles;

    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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
