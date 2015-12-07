package se.omegapoint.models;

import javax.persistence.Column;
import javax.persistence.Id;

public class Article extends  AbstractEntity implements Entity {

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
