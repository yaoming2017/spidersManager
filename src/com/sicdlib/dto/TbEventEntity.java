package com.sicdlib.dto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by YH on 2017/5/19.
 */
@Entity
@Table(name = "tb_event", schema = "socialmind", catalog = "")
public class TbEventEntity {

    private String id;
    private String eventName;
    private String eventIntroduction;
    private String eventSummary;
    private String eventStartTime;
    private String eventEndTime;
    private String eventRushTime;
    private Integer eventRushNum;
    private String eventSourceArticleId;
    private String eventTrend;
    //一对多
    private Set<TbEventArticleEntity> eventArticleSet = new HashSet<TbEventArticleEntity>();
    //一对多：一个事件对应多个源文章
    private Set<TbSourceArticleNumEntity> sourceArticleNumEntitySet = new HashSet<TbSourceArticleNumEntity>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<TbSourceArticleNumEntity> getSourceArticleNumEntitySet() {
        return sourceArticleNumEntitySet;
    }

    public void setSourceArticleNumEntitySet(Set<TbSourceArticleNumEntity> sourceArticleNumEntitySet) {
        this.sourceArticleNumEntitySet = sourceArticleNumEntitySet;
    }

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<TbEventArticleEntity> getEventArticleSet() {
        return eventArticleSet;
    }

    public void setEventArticleSet(Set<TbEventArticleEntity> eventArticleSet) {
        this.eventArticleSet = eventArticleSet;
    }

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "event_name")
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Basic
    @Column(name = "event_introduction")
    public String getEventIntroduction() {
        return eventIntroduction;
    }

    public void setEventIntroduction(String eventIntroduction) {
        this.eventIntroduction = eventIntroduction;
    }

    @Basic
    @Column(name = "event_summary")
    public String getEventSummary() {
        return eventSummary;
    }

    public void setEventSummary(String eventSummary) {
        this.eventSummary = eventSummary;
    }

    @Basic
    @Column(name = "event_start_time")
    public String getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    @Basic
    @Column(name = "event_end_time")
    public String getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    @Basic
    @Column(name = "event_rush_time")
    public String getEventRushTime() {
        return eventRushTime;
    }

    public void setEventRushTime(String eventRushTime) {
        this.eventRushTime = eventRushTime;
    }

    @Basic
    @Column(name = "event_rush_num")
    public Integer getEventRushNum() {
        return eventRushNum;
    }

    public void setEventRushNum(Integer eventRushNum) {
        this.eventRushNum = eventRushNum;
    }

    @Basic
    @Column(name = "event_source_article_id")
    public String getEventSourceArticleId() {
        return eventSourceArticleId;
    }

    public void setEventSourceArticleId(String eventSourceArticleId) {
        this.eventSourceArticleId = eventSourceArticleId;
    }

    @Basic
    @Column(name = "event_trend")
    public String getEventTrend() {
        return eventTrend;
    }

    public void setEventTrend(String eventTrend) {
        this.eventTrend = eventTrend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbEventEntity that = (TbEventEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (eventName != null ? !eventName.equals(that.eventName) : that.eventName != null) return false;
        if (eventIntroduction != null ? !eventIntroduction.equals(that.eventIntroduction) : that.eventIntroduction != null)
            return false;
        if (eventSummary != null ? !eventSummary.equals(that.eventSummary) : that.eventSummary != null) return false;
        if (eventStartTime != null ? !eventStartTime.equals(that.eventStartTime) : that.eventStartTime != null)
            return false;
        if (eventEndTime != null ? !eventEndTime.equals(that.eventEndTime) : that.eventEndTime != null) return false;
        if (eventRushTime != null ? !eventRushTime.equals(that.eventRushTime) : that.eventRushTime != null)
            return false;
        if (eventRushNum != null ? !eventRushNum.equals(that.eventRushNum) : that.eventRushNum != null) return false;
        if (eventSourceArticleId != null ? !eventSourceArticleId.equals(that.eventSourceArticleId) : that.eventSourceArticleId != null)
            return false;
        if (eventTrend != null ? !eventTrend.equals(that.eventTrend) : that.eventTrend != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
        result = 31 * result + (eventIntroduction != null ? eventIntroduction.hashCode() : 0);
        result = 31 * result + (eventSummary != null ? eventSummary.hashCode() : 0);
        result = 31 * result + (eventStartTime != null ? eventStartTime.hashCode() : 0);
        result = 31 * result + (eventEndTime != null ? eventEndTime.hashCode() : 0);
        result = 31 * result + (eventRushTime != null ? eventRushTime.hashCode() : 0);
        result = 31 * result + (eventRushNum != null ? eventRushNum.hashCode() : 0);
        result = 31 * result + (eventSourceArticleId != null ? eventSourceArticleId.hashCode() : 0);
        result = 31 * result + (eventTrend != null ? eventTrend.hashCode() : 0);
        return result;
    }
}
