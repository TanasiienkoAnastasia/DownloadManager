package org.example.DownloadManager;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
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
    private TextField urlTextField;

    @FXML
    private Hyperlink firefoxLink;

    @FXML
    private Hyperlink googleLink;

    @FXML
    private Hyperlink internetExplorerLink;

    @FXML
    private Hyperlink operaLink;


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
    void changeLocationButtonClicked(ActionEvent event) {
        new FileTransferLogin();
    }


    private String humanReadableByteCountBin(long bytes) {
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        char pre = "KMGTPE".charAt(exp - 1);
        return String.format("%.1f %sB", bytes / Math.pow(1024, exp), pre);
    }
}
