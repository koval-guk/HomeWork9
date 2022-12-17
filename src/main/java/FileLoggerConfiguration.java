import java.util.Date;

public class FileLoggerConfiguration {
    private String fileName = "hw9_log_%tF_%tH-%tM";
    private LoggingLevel level;
    private int maxSize = 200;
    private String format = "[%tT] [%s] Message:[%s]\n";


    public String getFileName() {
        return String.format(fileName, new Date(), new Date(), new Date());
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public String getFormat() {
        return format;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setLevel(LoggingLevel level) {
        this.level = level;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
