package org.example.DownloadManager.Command.ReceiverClasses;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DownloadManagerFileSystemReceiver implements FileSystemReceiver {
    @FXML
    private TextField urlTextField;
    @Override
    public void launchGoogle() {
        try {
            System.out.println("Launching Firefox");
            String command = "\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\"";
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void launchFirefox() {
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

    @Override
    public void launchOpera() {
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

    @Override
    public void launchInternetExplorer() {
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

}
