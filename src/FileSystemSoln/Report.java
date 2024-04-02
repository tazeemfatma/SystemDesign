package FileSystemSoln;

import java.util.List;

public class Report {

    long totalFileSize;
    List<String> topNCollectionId;

    public Report(long totalFileSize, List<String> topNCollectionId) {
        this.totalFileSize = totalFileSize;
        this.topNCollectionId = topNCollectionId;
    }
}
