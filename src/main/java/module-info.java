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
    opens org.example.DownloadManager.Chart to javafx.fxml;
    opens org.example.DownloadManager.CommandOpenBrowsers to javafx.fxml;
    opens org.example.DownloadManager.CommandDownloadViaBrowser to javafx.fxml;
    exports org.example.DownloadManager.Observer;
    exports org.example.DownloadManager.Chart;
    opens org.example.DownloadManager.Observer to javafx.fxml;
    exports org.example.DownloadManager.Observer.TemplateMethod;
    opens org.example.DownloadManager.Observer.TemplateMethod to javafx.fxml;
    exports org.example.DownloadManager.Observer.Iterator;
    opens org.example.DownloadManager.Observer.Iterator to javafx.fxml;
}