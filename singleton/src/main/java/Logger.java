import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    // Singleton instance
    private static Logger instance;

    // File handling
    private BufferedWriter writer;
    private String fileName;

    // Private constructor
    private Logger() {
        this.fileName = "log.txt"; // default file name
        openFile(this.fileName);
    }

    // Singleton access method
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Write a log message
    public synchronized void write(String message) {
        try {
            if (writer != null) {
                writer.write(message);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            System.err.println("Error writing to log file." + e.getMessage());
        }
    }

    // Change the log file
    public synchronized void setFilename(String newFileName) {
        close();
        this.fileName = newFileName;
        openFile(this.fileName);
    }

    // Open the log file
    private void openFile(String fileName) {
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.err.println("Error opening log file." + e.getMessage());
        }
    }

    // Close the log file
    public synchronized void close() {
        try {
            if (writer != null) {
                writer.close();
                writer = null;
            }
        } catch (IOException e) {
            System.err.println("Error closing log file." + e.getMessage());
        }
    }
}