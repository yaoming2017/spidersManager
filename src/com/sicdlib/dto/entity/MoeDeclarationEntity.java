package com.sicdlib.dto.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/6/11.
 */
@Entity
@Table(name = "moe_declaration", schema = "socialmind", catalog = "")
public class MoeDeclarationEntity {
    private String id;
    private String url;
    private String spiderPath;
    private String position;
    private String infoTitle;
    private String infoIndex;
    private String infoDate;
    private String infoInstitution;
    private String infoCategory;
    private String infoAbstract;
    private String infoContent;
    private String author;
    private String qrCodeUrl;
    private String qrCodeBase64;
    private Timestamp timeStamp;
    private String dateTime;
    private String fileName;
    private Integer fileNum;

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
    @Column(name = "info_title")
    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    @Basic
    @Column(name = "info_index")
    public String getInfoIndex() {
        return infoIndex;
    }

    public void setInfoIndex(String infoIndex) {
        this.infoIndex = infoIndex;
    }

    @Basic
    @Column(name = "info_date")
    public String getInfoDate() {
        return infoDate;
    }

    public void setInfoDate(String infoDate) {
        this.infoDate = infoDate;
    }

    @Basic
    @Column(name = "info_institution")
    public String getInfoInstitution() {
        return infoInstitution;
    }

    public void setInfoInstitution(String infoInstitution) {
        this.infoInstitution = infoInstitution;
    }

    @Basic
    @Column(name = "info_category")
    public String getInfoCategory() {
        return infoCategory;
    }

    public void setInfoCategory(String infoCategory) {
        this.infoCategory = infoCategory;
    }

    @Basic
    @Column(name = "info_abstract")
    public String getInfoAbstract() {
        return infoAbstract;
    }

    public void setInfoAbstract(String infoAbstract) {
        this.infoAbstract = infoAbstract;
    }

    @Basic
    @Column(name = "info_content")
    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
    @Column(name = "QRCode_base64")
    public String getQrCodeBase64() {
        return qrCodeBase64;
    }

    public void setQrCodeBase64(String qrCodeBase64) {
        this.qrCodeBase64 = qrCodeBase64;
    }

    @Basic
    @Column(name = "time_stamp")
    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Basic
    @Column(name = "date_time")
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Basic
    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "file_num")
    public Integer getFileNum() {
        return fileNum;
    }

    public void setFileNum(Integer fileNum) {
        this.fileNum = fileNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoeDeclarationEntity that = (MoeDeclarationEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (spiderPath != null ? !spiderPath.equals(that.spiderPath) : that.spiderPath != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (infoTitle != null ? !infoTitle.equals(that.infoTitle) : that.infoTitle != null) return false;
        if (infoIndex != null ? !infoIndex.equals(that.infoIndex) : that.infoIndex != null) return false;
        if (infoDate != null ? !infoDate.equals(that.infoDate) : that.infoDate != null) return false;
        if (infoInstitution != null ? !infoInstitution.equals(that.infoInstitution) : that.infoInstitution != null)
            return false;
        if (infoCategory != null ? !infoCategory.equals(that.infoCategory) : that.infoCategory != null) return false;
        if (infoAbstract != null ? !infoAbstract.equals(that.infoAbstract) : that.infoAbstract != null) return false;
        if (infoContent != null ? !infoContent.equals(that.infoContent) : that.infoContent != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (qrCodeUrl != null ? !qrCodeUrl.equals(that.qrCodeUrl) : that.qrCodeUrl != null) return false;
        if (qrCodeBase64 != null ? !qrCodeBase64.equals(that.qrCodeBase64) : that.qrCodeBase64 != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (fileNum != null ? !fileNum.equals(that.fileNum) : that.fileNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (spiderPath != null ? spiderPath.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (infoTitle != null ? infoTitle.hashCode() : 0);
        result = 31 * result + (infoIndex != null ? infoIndex.hashCode() : 0);
        result = 31 * result + (infoDate != null ? infoDate.hashCode() : 0);
        result = 31 * result + (infoInstitution != null ? infoInstitution.hashCode() : 0);
        result = 31 * result + (infoCategory != null ? infoCategory.hashCode() : 0);
        result = 31 * result + (infoAbstract != null ? infoAbstract.hashCode() : 0);
        result = 31 * result + (infoContent != null ? infoContent.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (qrCodeUrl != null ? qrCodeUrl.hashCode() : 0);
        result = 31 * result + (qrCodeBase64 != null ? qrCodeBase64.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (fileNum != null ? fileNum.hashCode() : 0);
        return result;
    }
}
