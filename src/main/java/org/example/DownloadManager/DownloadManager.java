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
import java.net.URISyntaxException;
import java.text.DecimalFormat;

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


    public static void launchFirefox(){
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
    @FXML
    void downloadButtonClicked(ActionEvent event) {
        String url = urlTextField.getText().trim();
        String filename = url.substring(url.lastIndexOf("/")+1);
        String status = "STARTING";
        String action = "OPEN";
        String path = AppConfig.DOWNLOAD_PATH + File.separator + filename;
        FileInfo file = new FileInfo((index+1) + "", filename, url, status, action, path, "0");
        this.index = this.index+1;
        DownloadThread thread = new DownloadThread(file, this);
        this.tableView.getItems().add(Integer.parseInt(file.getIndex())-1, file);
        thread.start();
    }

    @FXML
    void removeButtonClicked(ActionEvent event) {
        tableView.getItems().removeAll(
                tableView.getSelectionModel().getSelectedItems()
        );
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
    }
}
