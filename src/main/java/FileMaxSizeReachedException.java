public class FileMaxSizeReachedException extends Exception {


    public FileMaxSizeReachedException(int tempSize, int writeTrySize, int maxSize, String fileName) {
        System.out.println("File " + fileName + " reached " + tempSize + " byte and try to add " + writeTrySize + " byte of " + maxSize + " max");
    }
}
