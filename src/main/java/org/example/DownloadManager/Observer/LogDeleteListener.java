import java.io.File;

public class LogDeleteListener implements EventListener {
    private File log;

    public LogDeleteListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Delete from log " + log + ": Someone has performed "
                + eventType + " operation with the following file: " + file.getName());
    }
}
