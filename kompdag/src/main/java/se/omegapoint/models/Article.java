package se.omegapoint.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICLE")
public class Article extends  AbstractEntity implements BaseEntity {

    @Id
    private Long id;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "COLOR", nullable = false)
    private String color;

    @Column(name = "WEIGHT", nullable = false)
    private Long weight;

    @Column(name = "WEIGHT_UOM", nullable = false)
    private String weightUom;

}
