package com.sicdlib.dto.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/5/24.
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
    private Integer documentNum;
    private String infoCategory;
    private String infoAbstract;
    private String infoContent;
    private String publishDate;
    private String author;
    private String qrCodeUrl;
    private String qrCodeBase64;
    private String bQrCode;
    private String fileUrlNames;
    private String bFiles;
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
    @Column(name = "document_num")
    public Integer getDocumentNum() {
        return documentNum;
    }

    public void setDocumentNum(Integer documentNum) {
        this.documentNum = documentNum;
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
    @Column(name = "publish_date")
    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
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
    @Column(name = "b_QRCode")
    public String getbQrCode() {
        return bQrCode;
    }

    public void setbQrCode(String bQrCode) {
        this.bQrCode = bQrCode;
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
    @Column(name = "b_files")
    public String getbFiles() {
        return bFiles;
    }

    public void setbFiles(String bFiles) {
        this.bFiles = bFiles;
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
        if (documentNum != null ? !documentNum.equals(that.documentNum) : that.documentNum != null) return false;
        if (infoCategory != null ? !infoCategory.equals(that.infoCategory) : that.infoCategory != null) return false;
        if (infoAbstract != null ? !infoAbstract.equals(that.infoAbstract) : that.infoAbstract != null) return false;
        if (infoContent != null ? !infoContent.equals(that.infoContent) : that.infoContent != null) return false;
        if (publishDate != null ? !publishDate.equals(that.publishDate) : that.publishDate != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (qrCodeUrl != null ? !qrCodeUrl.equals(that.qrCodeUrl) : that.qrCodeUrl != null) return false;
        if (qrCodeBase64 != null ? !qrCodeBase64.equals(that.qrCodeBase64) : that.qrCodeBase64 != null) return false;
        if (bQrCode != null ? !bQrCode.equals(that.bQrCode) : that.bQrCode != null) return false;
        if (fileUrlNames != null ? !fileUrlNames.equals(that.fileUrlNames) : that.fileUrlNames != null) return false;
        if (bFiles != null ? !bFiles.equals(that.bFiles) : that.bFiles != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

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
        result = 31 * result + (documentNum != null ? documentNum.hashCode() : 0);
        result = 31 * result + (infoCategory != null ? infoCategory.hashCode() : 0);
        result = 31 * result + (infoAbstract != null ? infoAbstract.hashCode() : 0);
        result = 31 * result + (infoContent != null ? infoContent.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (qrCodeUrl != null ? qrCodeUrl.hashCode() : 0);
        result = 31 * result + (qrCodeBase64 != null ? qrCodeBase64.hashCode() : 0);
        result = 31 * result + (bQrCode != null ? bQrCode.hashCode() : 0);
        result = 31 * result + (fileUrlNames != null ? fileUrlNames.hashCode() : 0);
        result = 31 * result + (bFiles != null ? bFiles.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
