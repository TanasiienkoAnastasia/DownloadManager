package org.example.DownloadManager.CommandDownloadViaBrowser.Commands;

import org.example.DownloadManager.CommandDownloadViaBrowser.CommandInterface.Command;

import java.io.IOException;


public class DownloadLinkViaFirefoxCommand implements Command {
        private String url;

        public DownloadLinkViaFirefoxCommand(String url) {
            this.url = url;
        }

        @Override
        public void execute() {
            try {
                String command = "\"C:\\Program Files\\Mozilla Firefox\\firefox.exe\" " + url;
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

