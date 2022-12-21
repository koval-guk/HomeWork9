import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class FileLogger {
    FileLoggerConfiguration fileLoggerConfiguration;
    String tempFileName;
    int tempFileSize = 0;
    int fileNameCount = 1;

    public FileLogger(FileLoggerConfiguration fileLoggerConfiguration) {
        this.fileLoggerConfiguration = fileLoggerConfiguration;
        tempFileName = fileLoggerConfiguration.getFileName();
    }

    public void info(String message) {
        if (fileLoggerConfiguration.getLevel() == LoggingLevel.INFO || fileLoggerConfiguration.getLevel() == LoggingLevel.DEBUG) {
            try (FileOutputStream fos = new FileOutputStream(tempFileName, true);
                 BufferedOutputStream bos = new BufferedOutputStream(fos)) {
                String str = String.format(fileLoggerConfiguration.getFormat(), new Date(),
                        LoggingLevel.INFO, message);
                tempFileSize = (int) Files.size(Paths.get(tempFileName));
                if ((tempFileSize + str.getBytes().length) < fileLoggerConfiguration.getMaxSize()) {
                    bos.write(str.getBytes());
                    bos.flush();
                } else {
                    throw new FileMaxSizeReachedException(tempFileSize, str.getBytes().length, fileLoggerConfiguration.getMaxSize(), tempFileName);
                }
            } catch (IOException e) {
                System.out.println("Error");
            } catch (FileMaxSizeReachedException e) {
                tempFileName = fileLoggerConfiguration.getFileName();
                if (tempFileName.equals(fileLoggerConfiguration.getFileName())) {
                    tempFileName = tempFileName + "__" + fileNameCount;
                    fileNameCount++;
                } else {
                    fileNameCount = 1;
                }
                info(message);
            }
        }
    }

    public void debug(String message) {
        if (fileLoggerConfiguration.getLevel() == LoggingLevel.DEBUG) {
            try (FileOutputStream fos = new FileOutputStream(tempFileName, true);
                 BufferedOutputStream bos = new BufferedOutputStream(fos)) {
                String str = String.format(fileLoggerConfiguration.getFormat(), new Date(),
                        LoggingLevel.DEBUG, message);
                tempFileSize = (int) Files.size(Paths.get(tempFileName));
                if ((tempFileSize + str.getBytes().length) < fileLoggerConfiguration.getMaxSize()) {
                    bos.write(str.getBytes());
                    bos.flush();
                } else {
                    throw new FileMaxSizeReachedException(tempFileSize, str.getBytes().length, fileLoggerConfiguration.getMaxSize(), tempFileName);
                }
            } catch (IOException e) {
                System.out.println("Error");
            } catch (FileMaxSizeReachedException e) {
                tempFileName = fileLoggerConfiguration.getFileName();
                if (tempFileName.equals(fileLoggerConfiguration.getFileName())) {
                    tempFileName = tempFileName + "__" + fileNameCount;
                    fileNameCount++;
                } else {
                    fileNameCount = 1;
                }
                debug(message);
            }
        }
    }
}
