package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by YH on 2017/6/17.
 */
@Entity
@Table(name = "tb_event_author_mapping", schema = "socialmind")
public class TbEventAuthorMappingEntity {
    private String id;
    private TbAuthorEntity author;
    private TbEventEntity event;

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "tb_author_id", referencedColumnName = "id")
    public TbAuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(TbAuthorEntity author) {
        this.author = author;
    }

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    public TbEventEntity getEvent() {
        return event;
    }

    public void setEvent(TbEventEntity event) {
        this.event = event;
    }

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbEventAuthorMappingEntity that = (TbEventAuthorMappingEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
