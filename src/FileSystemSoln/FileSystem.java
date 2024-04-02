package FileSystemSoln;

import java.util.*;
import java.util.stream.Collectors;

public class FileSystem {

    /*
    *
    * Imagine we have a system that stores files, and these files can be grouped into collections.
        We are interested in knowing where our resources are being taken up.

        For this system, we would like to generate a report that lists:
        - The total size of all files stored; and
        - The top N collections (by file size) where N can be a user-defined value
    *
    *
    * */


    public static void main(String[] args) {
        ArrayList<File> list = new ArrayList();
        FileSystem fileSystem=new FileSystem();
        list.add(new File("file1.txt", 100, "collection3"));
        list.add(new File("file2.txt", 200, "collection1"));
        list.add(new File("file3.txt", 200, "collection1"));
        list.add(new File("file4.txt", 300, "collection2"));
        list.add(new File("file2.txt", 200, "collection2"));
        list.add(new File("file5.txt", 10, null));
        try {
            Report report = fileSystem.generateReport(list, 2);
            System.out.println(report.totalFileSize + ",");
            report.topNCollectionId.forEach(System.out::println);
        }catch (Exception e){
            System.out.println("Exception->"+e.getMessage());
        }
       // report.print();
    }

    public Report generateReport(List<File> files, long topNRecords) throws Exception {

        if(files.isEmpty()){
            System.out.println("Give proper list of files");
            return null;
        }
        long totalSize =0l;

        Map<String,Long> collectionsMapWithSize = new HashMap<>();

        for(File file:files){
            totalSize =totalSize + file.size;

            collectionsMapWithSize.put(file.collectionId,collectionsMapWithSize.getOrDefault(file.collectionId,0l)+ file.size);

        }

        System.out.println(collectionsMapWithSize);

        if(topNRecords > collectionsMapWithSize.size()) {
            throw new Exception("Please provide the valid values of topNFiles");
        }

        List<String> col=collectionsMapWithSize
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .map(e->e.getKey())
                .limit(topNRecords)
                .collect(Collectors.toList());
        return new Report(totalSize,col);
    }
}
