package org.example.DownloadManager;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.example.DownloadManager.models.FileInfo;
import views.FileTransferLogin;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DownloadManager {

    @FXML
    private TableView<FileInfo> tableView;

    @FXML
    private TextField urlTextField;

    @FXML
    private Hyperlink firefoxLink;

    @FXML
    private Hyperlink googleLink;

    @FXML
    private Hyperlink internetExplorerLink;

    @FXML
    private Hyperlink operaLink;

    private DownloadThread currentDownloadThread;


    public void launchFirefox(){
        try{
            System.out.println("Launching Firefox");
            String commandArr[] = {"\"C:\\Program Files\\Mozilla Firefox\\firefox.exe\""};
            Runtime runtimeObj = Runtime.getRuntime();
            runtimeObj.exec(commandArr);
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }
    }

    public long getTotalSizeOfFiles() {
        long totalSize = 0;
        for (FileInfo file : tableView.getItems()) {
            totalSize += file.getFilesize();
        }
        return totalSize;
    }

    @FXML
    void openFirefoxLink(ActionEvent event) throws URISyntaxException, IOException{
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System Name : " + osName);

        if (osName.startsWith("windows")){
            launchFirefox();
        }
        else
            System.out.println("Invalid Operating System");
    }



    public static void launchGoogle(){
        try{
            System.out.println("Launching Google");
            String commandArr[] = {"\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\""};
            Runtime runtimeObj = Runtime.getRuntime();
            runtimeObj.exec(commandArr);
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }
    }
    @FXML
    void openGoogleLink(ActionEvent event) throws URISyntaxException, IOException {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System Name : " + osName);

        if (osName.startsWith("windows")){
            launchGoogle();
        }
        else
            System.out.println("Invalid Operating System");
    }

    public static void launchIntenetExplorer(){
        try{
            System.out.println("Launching Internet Explorer");
            String commandArr[] = {"C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe"};
            Runtime runtimeObj = Runtime.getRuntime();
            runtimeObj.exec(commandArr);
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }
    }
    @FXML
    void openInternetExplorerLink(ActionEvent event) throws URISyntaxException, IOException {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System Name : " + osName);

        if (osName.startsWith("windows")){
            launchIntenetExplorer();
        }
        else
            System.out.println("Invalid Operating System");
    }

    public static void launchOpera(){
        try{
            System.out.println("Launching opera");
            String commandArr[] = {"C:\\Users\\shepe\\AppData\\Local\\Programs\\Opera\\launcher.exe"};
            Runtime runtimeObj = Runtime.getRuntime();
            runtimeObj.exec(commandArr);
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }
    }
    @FXML
    void openOperaLink(ActionEvent event) throws URISyntaxException, IOException {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System Name : " + osName);

        if (osName.startsWith("windows")){
            launchOpera();
        }
        else
            System.out.println("Invalid Operating System");
    }

    public int index = 0;

    private long getFileSize(String fileUrl) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(fileUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD");
            conn.getInputStream();
            return conn.getContentLengthLong();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    // Додайте метод для отримання типу файлу на основі імені файлу
    private String getFileType(String filename) {
        int dotIndex = filename.lastIndexOf(".");
        if (dotIndex > 0) {
            return filename.substring(dotIndex + 1);
        }
        return "Unknown";
    }

    // Додайте метод для отримання поточної дати у форматі "dd/MM/yyyy HH:mm:ss"
    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }
    @FXML
    void downloadButtonClicked(ActionEvent event) {
        String url = urlTextField.getText().trim();
        String filename = url.substring(url.lastIndexOf("/") + 1);
        String status = "STARTING";
        String action = "OPEN";
        String path = AppConfig.DOWNLOAD_PATH + File.separator + filename;

        long filesize = getFileSize(url); // Отримання розміру файлу

        // Отримайте тип файлу та поточну дату
        String fileType = getFileType(filename);
        String downloadDate = getCurrentDate();

        FileInfo file = new FileInfo((index + 1) + "", filename, url, status, action, path, "0", filesize);
        file.setFileType(fileType);
        file.setDownloadDate(downloadDate);

        this.index = this.index + 1;
        DownloadThread thread = new DownloadThread(file, this);
        thread.setDownloadSpeed(1024*1024);
        this.currentDownloadThread = thread;
        this.tableView.getItems().add(Integer.parseInt(file.getIndex()) - 1, file);
        thread.start();
    }

    @FXML
    void btnDownloadLinkViaFirefox(ActionEvent event) {
        String url = urlTextField.getText().trim();
        try {
            String command = "\"C:\\Program Files\\Mozilla Firefox\\firefox.exe\" " + url;
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnDownloadLinkViaGoogle(ActionEvent event) {
        String url = urlTextField.getText().trim();
        try {
            String command = "\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\"" + url;
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnDownloadLinkViaIE(ActionEvent event) {
        String url = urlTextField.getText().trim();
        try {
            String command = "\"C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe\"" + url;
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnDownloadLinkViaOpera(ActionEvent event) {
        String url = urlTextField.getText().trim();
        try {
            String command = "\"C:\\Users\\shepe\\AppData\\Local\\Programs\\Opera\\launcher.exe\"" + url;
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void pauseButtonClicked(ActionEvent event) {
        if (currentDownloadThread != null) {
            currentDownloadThread.pauseDownload();
        }
    }

    @FXML
    void resumeButtonClicked(ActionEvent event) {
        if (currentDownloadThread != null) {
            currentDownloadThread.resumeDownload();
        }
    }


  

    @FXML
    void changeLocationButtonClicked(ActionEvent event) {
        new FileTransferLogin();
    }

    public void updateUI(FileInfo metaFile) {
        System.out.println(metaFile);
        try {
            int index = Integer.parseInt(metaFile.getIndex()) - 1;
            if (index >= 0 && index < this.tableView.getItems().size()) {
                FileInfo fileInfo = this.tableView.getItems().get(index);
                fileInfo.setStatus(metaFile.getStatus());
                String perValue = metaFile.getPer().replace(',', '.');
                try {
                    double parsedPer = Double.parseDouble(perValue);
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    fileInfo.setPer(decimalFormat.format(parsedPer));
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing 'per' value: " + perValue);
                }
                this.tableView.refresh();
            } else {
                System.err.println("Invalid index: " + metaFile.getIndex());
            }
        } catch (NumberFormatException e) {
            System.err.println("Error parsing 'index' value: " + metaFile.getIndex());
        }
        System.out.println("_________________________");
        tableView.refresh();
    }

    private String humanReadableByteCountBin(long bytes) {
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        char pre = "KMGTPE".charAt(exp - 1);
        return String.format("%.1f %sB", bytes / Math.pow(1024, exp), pre);
    }


    @FXML
    public void initialize() {
        System.out.println("View initialized");


        TableColumn<FileInfo, String> sn = (TableColumn<FileInfo, String>) this.tableView.getColumns().get(0);
        sn.setCellValueFactory(p -> {
            return p.getValue().indexProperty();
        });

        TableColumn<FileInfo, String> filename = (TableColumn<FileInfo, String>) this.tableView.getColumns().get(1);
        filename.setCellValueFactory(p -> {
            return p.getValue().nameProperty();
        });

        TableColumn<FileInfo, String> url = (TableColumn<FileInfo, String>) this.tableView.getColumns().get(2);
        url.setCellValueFactory(p -> {
            return p.getValue().urlProperty();
        });

        TableColumn<FileInfo, String> status = (TableColumn<FileInfo, String>) this.tableView.getColumns().get(3);
        status.setCellValueFactory(p -> {
            return p.getValue().statusProperty();
        });

        TableColumn<FileInfo, String> per = (TableColumn<FileInfo, String>) this.tableView.getColumns().get(4);
        per.setCellValueFactory(p -> {
            SimpleStringProperty simpleStringProperty = new SimpleStringProperty();
            simpleStringProperty.set(p.getValue().getPer() + " %");
            return simpleStringProperty;
        });

        TableColumn<FileInfo, String> action = (TableColumn<FileInfo, String>) this.tableView.getColumns().get(5);
        action.setCellValueFactory(p -> {
            return p.getValue().actionProperty();
        });

        TableColumn<FileInfo, String> fileSizeColumn = new TableColumn<>("File Size");
        fileSizeColumn.setCellValueFactory(p -> {
            long size = p.getValue().getFilesize();
            String sizeString = size >= 0 ? humanReadableByteCountBin(size) : "Unknown";
            return new SimpleStringProperty(sizeString);
        });

        this.tableView.getColumns().add(fileSizeColumn);

        TableColumn<FileInfo, String> fileTypeColumn = new TableColumn<>("File Type");
        fileTypeColumn.setCellValueFactory(p -> p.getValue().fileTypeProperty());

        TableColumn<FileInfo, String> downloadDateColumn = new TableColumn<>("Date");
        downloadDateColumn.setCellValueFactory(p -> p.getValue().downloadDateProperty());

        this.tableView.getColumns().addAll(fileTypeColumn, downloadDateColumn);
    }
}
