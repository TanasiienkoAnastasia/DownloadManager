package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Download {
    public String filename;
    public String fileType;
    public String filesize;
    public String downloadDate;

    public Download(String filename,String filesize, String fileType ) {
        this.filename = filename;
        this.filesize = filesize;
        this.fileType = fileType;
        final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        downloadDate = LocalDateTime.now().format(format);
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public String getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(String downloadDate) {
        this.downloadDate = downloadDate;
    }
}
