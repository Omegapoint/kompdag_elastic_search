package se.omegapoint.models;

import se.omegapoint.converters.LocalDateTimeTimestampConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractEntity {

    @Column(name = "CREATE_DATETIME", nullable = false)
    @Convert(converter = LocalDateTimeTimestampConverter.class)
    private LocalDateTime createDatetime;

    @Column(name = "LAST_UPDATE_DATETIME", nullable = false)
    @Convert(converter = LocalDateTimeTimestampConverter.class)
    private LocalDateTime lastUpdateDatetime;

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
}