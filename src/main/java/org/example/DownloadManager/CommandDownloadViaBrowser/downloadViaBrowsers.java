package org.example.DownloadManager.CommandDownloadViaBrowser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.DownloadManager.CommandDownloadViaBrowser.CommandInterface.Command;
import org.example.DownloadManager.CommandDownloadViaBrowser.Commands.DownloadLinkViaFirefoxCommand;
import org.example.DownloadManager.CommandDownloadViaBrowser.Commands.DownloadLinkViaGoogleCommand;
import org.example.DownloadManager.CommandDownloadViaBrowser.Commands.DownloadLinkViaInternetExplorerCommand;
import org.example.DownloadManager.CommandDownloadViaBrowser.Commands.DownloadLinkViaOperaCommand;


public class downloadViaBrowsers {


    @FXML
    private TextField urlTextField;

    private void executeCommand(Command command) {
        command.execute();
    }

    @FXML
    void btnDownloadLinkViaFirefox(ActionEvent event) {
        executeCommand(new DownloadLinkViaFirefoxCommand(urlTextField.getText().trim()));
    }

    @FXML
    void btnDownloadLinkViaGoogle(ActionEvent event) {
        executeCommand(new DownloadLinkViaGoogleCommand(urlTextField.getText().trim()));
    }



    @FXML
    void btnDownloadLinkViaIE(ActionEvent event) {
        executeCommand(new DownloadLinkViaInternetExplorerCommand(urlTextField.getText().trim()));
    }

    @FXML
    void btnDownloadLinkViaOpera(ActionEvent event) {
        executeCommand(new DownloadLinkViaOperaCommand(urlTextField.getText().trim()));
    }
}

