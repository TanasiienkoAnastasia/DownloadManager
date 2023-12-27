package org.example.DownloadManager.Command;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import org.example.DownloadManager.Command.Commands.LaunchFirefoxCommand;
import org.example.DownloadManager.Command.Commands.LaunchGoogleCommand;
import org.example.DownloadManager.Command.Commands.LaunchInternetExplorerCommand;
import org.example.DownloadManager.Command.Commands.LaunchOperaCommand;
import org.example.DownloadManager.Command.InvokerClasses.FileInvoker;
import org.example.DownloadManager.Command.ReceiverClasses.DownloadManagerFileSystemReceiver;


import java.io.IOException;
import java.net.URISyntaxException;

import static javafx.application.Application.launch;

public class openBrowsers {
    DownloadManagerFileSystemReceiver fs = new DownloadManagerFileSystemReceiver();
    @FXML
    private Hyperlink firefoxLink;

    @FXML
    private Hyperlink googleLink;

    @FXML
    private Hyperlink internetExplorerLink;

    @FXML
    private Hyperlink operaLink;


    @FXML
    void openGoogleLink(ActionEvent event) throws URISyntaxException, IOException {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System Name : " + osName);
        LaunchGoogleCommand launchGoogleCommand = new LaunchGoogleCommand(fs);
        if (osName.startsWith("windows")){
            FileInvoker file = new FileInvoker(launchGoogleCommand);
            file.execute();
        }
        else
            System.out.println("Invalid Operating System");
    }


    @FXML
    void openFirefoxLink(ActionEvent event) {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System Name : " + osName);
        LaunchFirefoxCommand launchFirefoxCommand = new LaunchFirefoxCommand(fs);
        if (osName.startsWith("windows")){
            FileInvoker file = new FileInvoker(launchFirefoxCommand);
            file.execute();
        }
        else
            System.out.println("Invalid Operating System");
    }

    @FXML
    void openInternetExplorerLink(ActionEvent event) {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System Name : " + osName);
        LaunchInternetExplorerCommand launchInternetExplorerCommand = new LaunchInternetExplorerCommand(fs);
        if (osName.startsWith("windows")){
            FileInvoker file = new FileInvoker(launchInternetExplorerCommand);
            file.execute();
        }
        else
            System.out.println("Invalid Operating System");
    }

    @FXML
    void openOperaLink(ActionEvent event) {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System Name : " + osName);
        LaunchOperaCommand launchOperaCommandCommand = new LaunchOperaCommand(fs);
        if (osName.startsWith("windows")){
            FileInvoker file = new FileInvoker(launchOperaCommandCommand);
            file.execute();
        }
        else
            System.out.println("Invalid Operating System");
    }
}
