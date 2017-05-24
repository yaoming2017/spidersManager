package com.sicdlib.dto;

import javax.persistence.*;

/**
 * Created by YH on 2017/5/19.
 */
@Entity
@Table(name = "tb_stop_words")
public class TbStopWordsEntity {
    private int id;
    private String word;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "word")
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbStopWordsEntity that = (TbStopWordsEntity) o;

        if (id != that.id) return false;
        if (word != null ? !word.equals(that.word) : that.word != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (word != null ? word.hashCode() : 0);
        return result;
    }
}
