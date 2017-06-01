package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by YH on 2017/5/19.
 */
@Entity
@Table(name = "tb_source_article_num", schema = "socialmind", catalog = "")
public class TbSourceArticleNumEntity {
    private String id;
    private int num;
    private String startTime;
    private String endTime;
    //多对一：多个对应一张表
    private TbTableEntity table;
    //多对一：多个对应一个事件
    private TbEventEntity event;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    public TbEventEntity getEvent() {
        return event;
    }

    public void setEvent(TbEventEntity event) {
        this.event = event;
    }

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
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
    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Basic
    @Column(name = "start_time")
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbSourceArticleNumEntity that = (TbSourceArticleNumEntity) o;

        if (num != that.num) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + num;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }
}
