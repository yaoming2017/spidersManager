package com.sicdlib.dto;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
 */
@Entity
@Table(name = "moe_data", schema = "socialmind", catalog = "")
public class MoeDataEntity {
    private String id;
    private String url;
    private String spiderPath;
    private String position;
    private String date;
    private String titleYt;
    private String title;
    private String subTitle;
    private String titleFwzh;
    private String content;
    private String editor;
    private String fileUrlNames;
    private String qrCodeUrl;
    private String bFiles;
    private String bQrCode;
    private Timestamp timeStamp;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "spider_path")
    public String getSpiderPath() {
        return spiderPath;
    }

    public void setSpiderPath(String spiderPath) {
        this.spiderPath = spiderPath;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "title_yt")
    public String getTitleYt() {
        return titleYt;
    }

    public void setTitleYt(String titleYt) {
        this.titleYt = titleYt;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "sub_title")
    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Basic
    @Column(name = "title_fwzh")
    public String getTitleFwzh() {
        return titleFwzh;
    }

    public void setTitleFwzh(String titleFwzh) {
        this.titleFwzh = titleFwzh;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "editor")
    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Basic
    @Column(name = "file_url_names")
    public String getFileUrlNames() {
        return fileUrlNames;
    }

    public void setFileUrlNames(String fileUrlNames) {
        this.fileUrlNames = fileUrlNames;
    }

    @Basic
    @Column(name = "QRCode_url")
    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    @Basic
    @Column(name = "b_files")
    public String getbFiles() {
        return bFiles;
    }

    public void setbFiles(String bFiles) {
        this.bFiles = bFiles;
    }

    @Basic
    @Column(name = "b_QRCode")
    public String getbQrCode() {
        return bQrCode;
    }

    public void setbQrCode(String bQrCode) {
        this.bQrCode = bQrCode;
    }

    @Basic
    @Column(name = "time_stamp")
    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoeDataEntity that = (MoeDataEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (spiderPath != null ? !spiderPath.equals(that.spiderPath) : that.spiderPath != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (titleYt != null ? !titleYt.equals(that.titleYt) : that.titleYt != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (subTitle != null ? !subTitle.equals(that.subTitle) : that.subTitle != null) return false;
        if (titleFwzh != null ? !titleFwzh.equals(that.titleFwzh) : that.titleFwzh != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (editor != null ? !editor.equals(that.editor) : that.editor != null) return false;
        if (fileUrlNames != null ? !fileUrlNames.equals(that.fileUrlNames) : that.fileUrlNames != null) return false;
        if (qrCodeUrl != null ? !qrCodeUrl.equals(that.qrCodeUrl) : that.qrCodeUrl != null) return false;
        if (bFiles != null ? !bFiles.equals(that.bFiles) : that.bFiles != null) return false;
        if (bQrCode != null ? !bQrCode.equals(that.bQrCode) : that.bQrCode != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (spiderPath != null ? spiderPath.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (titleYt != null ? titleYt.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (subTitle != null ? subTitle.hashCode() : 0);
        result = 31 * result + (titleFwzh != null ? titleFwzh.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (editor != null ? editor.hashCode() : 0);
        result = 31 * result + (fileUrlNames != null ? fileUrlNames.hashCode() : 0);
        result = 31 * result + (qrCodeUrl != null ? qrCodeUrl.hashCode() : 0);
        result = 31 * result + (bFiles != null ? bFiles.hashCode() : 0);
        result = 31 * result + (bQrCode != null ? bQrCode.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
