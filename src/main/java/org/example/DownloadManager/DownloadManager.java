package org.example.DownloadManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import views.FileTransferLogin;


public class DownloadManager {
    @FXML
    void changeLocationButtonClicked(ActionEvent event) {
        new FileTransferLogin();
    }

}
