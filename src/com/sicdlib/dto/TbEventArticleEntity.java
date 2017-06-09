package com.sicdlib.dto;

import javax.persistence.*;
import java.util.Collection;

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
    private Byte isTurnPoint;
    private Float simiDegree;
    //多对一：多个事件文章对应一个事件
    private TbEventEntity event;
    //多对一：多个事件文章对应一个表
    private TbTableEntity table;

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    public TbEventEntity getEvent() {
        return event;
    }

    public void setEvent(TbEventEntity event) {
        this.event = event;
    }

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    public TbTableEntity getTable() {
        return table;
    }

    public void setTable(TbTableEntity table) {
        this.table = table;
    }

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
    @Column(name = "is_turn_point")
    public Byte getIsTurnPoint() {
        return isTurnPoint;
    }

    public void setIsTurnPoint(Byte isTurnPoint) {
        this.isTurnPoint = isTurnPoint;
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
        if (isTurnPoint != null ? !isTurnPoint.equals(that.isTurnPoint) : that.isTurnPoint != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (heat != null ? heat.hashCode() : 0);
        result = 31 * result + (sourceArticleId != null ? sourceArticleId.hashCode() : 0);
        result = 31 * result + (isTurnPoint != null ? isTurnPoint.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "simi_degree")
    public Float getSimiDegree() {
        return simiDegree;
    }

    public void setSimiDegree(Float simiDegree) {
        this.simiDegree = simiDegree;
    }

    private Collection<TbArticleSimilarityEntity> tbArticleSimilarityEntity;

    @OneToMany(mappedBy = "articleA")
    public Collection<TbArticleSimilarityEntity> getTbArticleSimilarityEntity() {
        return tbArticleSimilarityEntity;
    }

    public void setTbArticleSimilarityEntity(Collection<TbArticleSimilarityEntity> tbArticleSimilarityEntity) {
        this.tbArticleSimilarityEntity = tbArticleSimilarityEntity;
    }
}
