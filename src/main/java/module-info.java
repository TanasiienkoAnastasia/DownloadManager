module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires com.google.gson;

    opens org.example to javafx.fxml;
    exports org.example;
    exports controllers;
    exports Helpers;
    exports models;
    exports ServerClient;
    exports views;
    exports org.example.DownloadManager;
    opens org.example.DownloadManager to javafx.fxml;
    opens org.example.DownloadManager.Command to javafx.fxml;
    exports org.example.DownloadManager.Observer;
    opens org.example.DownloadManager.Observer to javafx.fxml;
}