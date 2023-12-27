public class Main {
    public static void main(String[] args) {
            Editor editor = new Editor();
            editor.events.subscribe("add", new LogAddListener("/path/to/log/file.txt"));
            editor.events.subscribe("delete", new LogDeleteListener("/path/to/log/file.txt"));

            try {
                editor.addFile("test.txt");
                editor.deleteFile("test.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
