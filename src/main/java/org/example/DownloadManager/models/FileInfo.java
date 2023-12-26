package org.example.DownloadManager.models;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class FileInfo {

    private SimpleStringProperty index = new SimpleStringProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty url = new SimpleStringProperty();
    private SimpleStringProperty status = new SimpleStringProperty();
    private SimpleStringProperty action = new SimpleStringProperty();
    private SimpleStringProperty path = new SimpleStringProperty();
    private SimpleStringProperty per = new SimpleStringProperty();
    private SimpleLongProperty filesize = new SimpleLongProperty();
    private SimpleStringProperty fileType = new SimpleStringProperty(); // Додано поле для типу файлу
    private SimpleStringProperty downloadDate = new SimpleStringProperty(); // Додано поле для дати завантаження

    public FileInfo(String index, String name, String url, String status, String action, String path, String per, long filesize) {
        this.index.set(index);
        this.name.set(name);
        this.url.set(url);
        this.status.set(status);
        this.action.set(action);
        this.path.set(path);
        this.per.set(per);
        this.filesize.set(filesize);
    }

    public long getFilesize() {
        return filesize.get();
    }

    public void setFilesize(long filesize) {
        this.filesize.set(filesize);
    }

    public SimpleLongProperty filesizeProperty() {
        return filesize;
    }

    public String getPer() {
        return per.get();
    }

    public SimpleStringProperty perProperty() {
        return per;
    }

    public void setPer(String per) {
        this.per.set(per);
    }

    public String getIndex() {
        return index.get();
    }

    public SimpleStringProperty indexProperty() {
        return index;
    }

    public void setIndex(String index) {
        this.index.set(index);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getUrl() {
        return url.get();
    }

    public SimpleStringProperty urlProperty() {
        return url;
    }

    public void setUrl(String url) {
        this.url.set(url);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getAction() {
        return action.get();
    }

    public SimpleStringProperty actionProperty() {
        return action;
    }

    public void setAction(String action) {
        this.action.set(action);
    }

    public String getPath() {
        return path.get();
    }

    public SimpleStringProperty pathProperty() {
        return path;
    }

    public void setPath(String path) {
        this.path.set(path);
    }

    public String getFiletype() {
        return fileType.get();
    }

    public SimpleStringProperty fileTypeProperty() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType.set(fileType);
    }

    public String getDownloadDate() {
        return downloadDate.get();
    }

    public SimpleStringProperty downloadDateProperty() {
        return downloadDate;
    }

    public void setDownloadDate(String downloadDate) {
        this.downloadDate.set(downloadDate);
    }

    public String toString() {
        return "FileInfo{" +
                "index=" + index.get() +
                ", name=" + name.get() +
                ", url=" + url.get() +
                ", status=" + status.get() +
                ", action=" + action.get() +
                ", path=" + path.get() +
                ", per=" + per.get() +
                ", filesize=" + filesize.get() +
                ", fileType=" + fileType.get() + // Додано тип файлу у toString
                ", downloadDate=" + downloadDate.get() + // Додано дату завантаження у toString
                '}';
    }
}