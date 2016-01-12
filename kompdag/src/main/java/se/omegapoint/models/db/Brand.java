package se.omegapoint.models.db;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BRAND", uniqueConstraints = @UniqueConstraint(name = "UQ_BRAND_BRAND_NAME", columnNames = "BRAND_NAME"))
public class Brand extends AbstractEntity {

    @Column(name = "BRAND_NAME", nullable = false, unique = true)
    private String brandName;

    @Column(name = "ESTABLISHED_YEAR", nullable = false, unique = false)
    private Long establishedYear;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand", orphanRemoval = false)
    private Set<Article> articles;

    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getEstablishedYear() {
        return establishedYear;
    }
    public void setEstablishedYear(Long establishedYear) {
        this.establishedYear = establishedYear;
    }

    public Set<Article> getArticles() {
        return articles;
    }
    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
