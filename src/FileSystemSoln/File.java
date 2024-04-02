package FileSystemSoln;

public class File {
    String fileId;
    long size;
    String collectionId;

    public File(String fileId, long size, String collectionId) {
        this.fileId = fileId;
        this.size = size;
        this.collectionId = collectionId;
    }
}
