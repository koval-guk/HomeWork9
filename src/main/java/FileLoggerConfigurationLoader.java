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
            String str = br.readLine();
            while (!(str == null)) {
                System.out.println("Load: "+str);
                if (str.contains("FILE")) {
                    fileLoggerConfiguration.setFileName(str.replaceFirst("FILE: ", ""));
                    System.out.println("file");
                }
                if (str.contains("LEVEL")) {
                    fileLoggerConfiguration.setLevel(LoggingLevel.valueOf(str.replaceFirst("LEVEL: ", "")));
                }
                if (str.contains("MAX-SIZE")) {
                    fileLoggerConfiguration.setMaxSize(Integer.parseInt(str.replaceFirst("MAX-SIZE: ", "")));
                }
                if (str.contains("FORMAT")) {
                    fileLoggerConfiguration.setFormat(str.replaceFirst("FORMAT: ", ""));
                }
                str = br.readLine();
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("File " + configurationFile + " not found or contains invalid format.");
        }
        return fileLoggerConfiguration;
    }
}
