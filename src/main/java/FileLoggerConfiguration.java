import java.util.Date;

public class FileLoggerConfiguration {
    private String fileName = "hw9_log_%tF_%tH-%tM"; //sorry, i don't understand how to make this fields final
    private LoggingLevel level;                     //and i think not static it looks better
    private int maxSize = 200;                      //both cases increase amount of letters...
    private String format = "[%tT] [%s] Message:[%s]\n";  //(my english not good. i don't have ukrainian on leptop:))


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
