import java.io.*;

public class FileLoggerConfigurationLoader {
    private final String configurationFile;
    FileLoggerConfiguration fileLoggerConfiguration;

    public FileLoggerConfigurationLoader(String configurationFile) {
        this.configurationFile = configurationFile;
    }

    public FileLoggerConfiguration load() {
        fileLoggerConfiguration = new FileLoggerConfiguration();
        try (BufferedReader br = new BufferedReader(new FileReader(configurationFile))) {
            String file = br.readLine().replaceFirst("FILE: ", "").toLowerCase();
            System.out.println(file);
            String level = br.readLine().replaceFirst("LEVEL: ", "").toUpperCase();
            System.out.println(level);
            String max_size_str = (br.readLine().replaceFirst("MAX-SIZE: ", ""));
            int max_size = Integer.parseInt(max_size_str);
            System.out.println(max_size);
            String format = br.readLine().replaceFirst("FORMAT: ", "");
            System.out.println(format);
            fileLoggerConfiguration.setFileName(file);
            fileLoggerConfiguration.setLevel(LoggingLevel.valueOf(level));
            fileLoggerConfiguration.setMaxSize(max_size);
            fileLoggerConfiguration.setFormat(format);
        } catch (IOException | NumberFormatException e) {
            System.out.println("File " + configurationFile + " not found or contains invalid format.");
        }
        return fileLoggerConfiguration;
    }
}
