package se.omegapoint.models.db;

import se.omegapoint.converters.LocalDateTimeTimestampConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    private Long id;

    @Column(name = "CREATE_DATETIME", nullable = false)
    @Convert(converter = LocalDateTimeTimestampConverter.class)
    private LocalDateTime createDatetime;

    @Column(name = "LAST_UPDATE_DATETIME", nullable = false)
    @Convert(converter = LocalDateTimeTimestampConverter.class)
    private LocalDateTime lastUpdateDatetime;

    @Column(name = "UTILITY", nullable = true)
    private String utility;

    public LocalDateTime getCreateDatetime() {
        return createDatetime;
    }
    public void setCreateDatetime(LocalDateTime createDatetime) {
        this.createDatetime = createDatetime;
    }

    public LocalDateTime getLastUpdateDatetime() {
        return lastUpdateDatetime;
    }
    public void setLastUpdateDatetime(LocalDateTime lastUpdateDatetime) {
        this.lastUpdateDatetime = lastUpdateDatetime;
    }

    public String getUtility() {
        return utility;
    }
    public void setUtility(String utility) {
        this.utility = utility;
    }

    @PrePersist
    public void prePersist() {
        if (createDatetime == null) {
            setCreateDatetime(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate() {
        setLastUpdateDatetime(LocalDateTime.now());
    }

}