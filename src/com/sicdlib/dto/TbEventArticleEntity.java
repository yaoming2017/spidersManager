package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by YH on 2017/5/19.
 */
@Entity
@Table(name = "tb_event_article", schema = "socialmind", catalog = "")
public class TbEventArticleEntity {

    private String id;
    private String time;
    private Double heat;
    private String sourceArticleId;
    private String eventId;
    private String abstractId;
    private Byte isTurnPoint;
    private String tableId;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
    @Column(name = "source_article_id")
    public String getSourceArticleId() {
        return sourceArticleId;
    }

    public void setSourceArticleId(String sourceArticleId) {
        this.sourceArticleId = sourceArticleId;
    }

    @Basic
    @Column(name = "event_id")
    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "abstract_id")
    public String getAbstractId() {
        return abstractId;
    }

    public void setAbstractId(String abstractId) {
        this.abstractId = abstractId;
    }

    @Basic
    @Column(name = "is_turn_point")
    public Byte getIsTurnPoint() {
        return isTurnPoint;
    }

    public void setIsTurnPoint(Byte isTurnPoint) {
        this.isTurnPoint = isTurnPoint;
    }

    @Basic
    @Column(name = "table_id")
    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbEventArticleEntity that = (TbEventArticleEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (heat != null ? !heat.equals(that.heat) : that.heat != null) return false;
        if (sourceArticleId != null ? !sourceArticleId.equals(that.sourceArticleId) : that.sourceArticleId != null)
            return false;
        if (eventId != null ? !eventId.equals(that.eventId) : that.eventId != null) return false;
        if (abstractId != null ? !abstractId.equals(that.abstractId) : that.abstractId != null) return false;
        if (isTurnPoint != null ? !isTurnPoint.equals(that.isTurnPoint) : that.isTurnPoint != null) return false;
        if (tableId != null ? !tableId.equals(that.tableId) : that.tableId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (heat != null ? heat.hashCode() : 0);
        result = 31 * result + (sourceArticleId != null ? sourceArticleId.hashCode() : 0);
        result = 31 * result + (eventId != null ? eventId.hashCode() : 0);
        result = 31 * result + (abstractId != null ? abstractId.hashCode() : 0);
        result = 31 * result + (isTurnPoint != null ? isTurnPoint.hashCode() : 0);
        result = 31 * result + (tableId != null ? tableId.hashCode() : 0);
        return result;
    }
}
