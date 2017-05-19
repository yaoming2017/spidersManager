package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by YH on 2017/5/19.
 */
@Entity
@Table(name = "tb_hot_word", schema = "socialMind")
public class TbHotWordEntity {
    private String id;
    private String name;
    private Double heat;
    private String eventId;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "heat")
    public Double getHeat() {
        return heat;
    }

    public void setHeat(Double heat) {
        this.heat = heat;
    }

    @Basic
    @Column(name = "event_id")
    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbHotWordEntity that = (TbHotWordEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (heat != null ? !heat.equals(that.heat) : that.heat != null) return false;
        if (eventId != null ? !eventId.equals(that.eventId) : that.eventId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (heat != null ? heat.hashCode() : 0);
        result = 31 * result + (eventId != null ? eventId.hashCode() : 0);
        return result;
    }
}
