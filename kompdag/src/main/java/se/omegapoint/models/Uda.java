package se.omegapoint.models;

import javax.persistence.*;

@Entity
@Table(name = "UDA", uniqueConstraints = @UniqueConstraint(name = "UQ_UDA_ARTICLE_ATTR", columnNames = {"ARTICLE_ID", "ATTRIBUTE"}))
public class Uda extends AbstractEntity {

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Article.class, optional = false)
    @JoinColumn(name = "ARTICLE_ID", nullable = false, insertable = false, updatable = false)
    private Article article;

    @Column(name = "ATTRIBUTE", nullable = false, insertable = false, updatable = false)
    private String attribute;

    @Column(name = "VALUE", nullable = false, insertable = false, updatable = false)
    private String value;

    public Article getArticle() {
        return article;
    }
    public void setArticle(Article article) {
        this.article = article;
    }

    public String getAttribute() {
        return attribute;
    }
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
