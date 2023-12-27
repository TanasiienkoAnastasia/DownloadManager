import java.io.File;

public class LogAddListener implements EventListener {
    private File log;

    public LogAddListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Add to log " + log + ": Someone has performed "
                + eventType + " operation with the following file: " + file.getName());
    }
}
