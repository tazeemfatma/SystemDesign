package Solution;

import java.util.ArrayList;

import java.util.Collection;

import java.util.Collections;

import java.util.Comparator;

import java.util.HashMap;

import java.util.HashSet;

import java.util.List;

import java.util.Map;

import java.util.Set;

import java.util.stream.Collectors;

public class CollectionsOfFiles {

    /**

     *

     * Imagine we have a system that stores files, and these files can be grouped into collections.

     * We are interested in knowing where our resources are being taken up.

     *

     *  For this system, we would like to generate a report that lists:

     *      - The total size of all files stored; and

     *      - The top N collections (by file size) where N can be a user-defined value

     *

     *  1) What do you mean by collections here is it going to be a folder or something else?

     *  2) Can the file not be in collections or can be a single file?

     *  3) What all metadata File contains like fileName, size , collectionId (can be empty)

     *  4) What if N is greater than total collections List of input, in that case how will my report look like?

     *

     *

     *

     *     The simple solution we can think of using a Hashmap to store <key-collectionID, value- fileSize>

     *

     */


    static void scenario0() {

        ArrayList<FileMetadata> list = new ArrayList();

        list.add(new FileMetadata("file1.txt", 100, null));

        list.add(new FileMetadata("file2.txt", 200, "collection1"));

        list.add(new FileMetadata("file3.txt", 200, "collection1"));

        list.add(new FileMetadata("file4.txt", 300, "collection2"));

        list.add(new FileMetadata("file5.txt", 10, null));

        Report report = generateReport(list, 5);

        report.print();

    }


    static Report generateReport(Collection<FileMetadata> files, int N) {

        Map<String, Long> collectionsList = new HashMap<>();

        long total = 0l;

        for (FileMetadata file : files) {

            total += file.size;

            if (file.collectionId != null) {

                collectionsList.put(file.collectionId, collectionsList.getOrDefault(file.collectionId, 0l) + file.size);

            }

        }

        if (N > collectionsList.size()) {

            // as per contract

        }

        List<CollectionData> topNList = collectionsList.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(a->new CollectionData(a.getKey(), a.getValue()))
                .limit(N)
                .toList();

        return new Report (total, topNList);

    }

    // Level 1: Files in multiple collections

    /**

     * file1.txt (size: 100)

     * file2.txt (size: 200) in collection "collection1"

     * file3.txt (size: 200) in collection "collection1"

     * file4.txt (size: 300) in collection "collection2" and "collection3"

     * file5.txt (size: 10)

     */

    static Report generateReport1(Collection<FileMetadata1> files, int N) {

        Map<String, Long> collectionsList = new HashMap<>();

        long total = 0l;

        for (FileMetadata1 file : files) {

            total += file.size;

            if (file.collectionIds != null) {

                file.collectionIds.stream().forEach( a ->

                        collectionsList.put(a, collectionsList.getOrDefault(a, 0l) + file.size));

            }

        }

        if (N > collectionsList.size()) {

            // as per contract

        }

        List<CollectionData> topNList = collectionsList.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).map(a->new CollectionData(a.getKey(), a.getValue())).limit(N).toList();

        return new Report (total, topNList);

    }

    static void scenario1() {

        ArrayList<FileMetadata1> list = new ArrayList();

        list.add(new FileMetadata1("file1.txt", 100, null));

        list.add(new FileMetadata1("file2.txt", 200, List.of("collection1")));

        list.add(new FileMetadata1("file3.txt", 200, List.of("collection1")));

        list.add(new FileMetadata1("file4.txt", 300, List.of("collection2", "collection3")));

        list.add(new FileMetadata1("file5.txt", 10, null));

        Report report = generateReport1(list, 5);

        report.print();

    }




    // Level2 Hierarchical collections

    /**

     * files:

     * file1.txt (size: 100)

     * file2.txt (size: 200) in collection "collection1"

     * file3.txt (size: 200) in collection "collection1"

     * file4.txt (size: 300) in collection "collection2" and "collection3"

     * file5.txt (size: 10)

     *

     * collections:

     * "collection1" has no parent

     * "collection2" has parent "collection1"

     * "collection3" has no parent

     *

     * The size of a collection is the total size of all of its child collections, plus the total size of any files in the collection itself.

     */

    static Report generateReport(Collection<FileMetadata1> files, Collection<CollectionTreeEdgeDefinition> collectionHierarchy, int N) {

        List<CollectionTreeEdgeDefinition> nonRootNodes = collectionHierarchy.stream().filter(a -> a.parentId != null).collect(Collectors.toList());


        Map<String, CollectionData> collectionsList = new HashMap<>();

        long total = 0l;

        for (FileMetadata1 file : files) {

            total += file.size;

            Set<String> visitedCollections = new HashSet<>();

            List<String> collectionToVisit;

            if (file.collectionIds == null)

                collectionToVisit = new ArrayList<>();

            else {

                collectionToVisit = new ArrayList<>(file.collectionIds);

            }

            while (!collectionToVisit.isEmpty()) {

                String collectionId = collectionToVisit.remove(0);

                if (visitedCollections.contains(collectionId))

                    continue;

                collectionsList.putIfAbsent(collectionId, new CollectionData(collectionId, 0));

                CollectionData collectionData = collectionsList.get(collectionId);

                collectionData.size += file.size;

                visitedCollections.add(collectionId);

                nonRootNodes.stream().filter(a-> a.id.equals(collectionId)).forEach(a-> collectionToVisit.add(a.parentId));

            }

        }

        if (N > collectionsList.size()) {

            // as per contract

        }

        List<CollectionData> topNList = collectionsList.entrySet().stream().sorted(Collections.reverseOrder(Comparator.comparingLong(a-> a.getValue().size))).map(a->new CollectionData(a.getKey(), a.getValue().size)).limit(N).collect(Collectors.toList());

        return new Report (total, topNList);

    }

    static void scenario2() {

        ArrayList<FileMetadata1> list = new ArrayList();

        list.add(new FileMetadata1("file1.txt", 100, null));

        list.add(new FileMetadata1("file2.txt", 200, List.of("collection1")));

        list.add(new FileMetadata1("file3.txt", 200, List.of("collection1")));

        list.add(new FileMetadata1("file4.txt", 300, List.of("collection2", "collection3")));

        list.add(new FileMetadata1("file5.txt", 10, null));

        List<CollectionTreeEdgeDefinition> collections = new ArrayList<>();

        collections.add(new CollectionTreeEdgeDefinition("collection1", null));

        collections.add(new CollectionTreeEdgeDefinition("collection2", "collection1"));

        collections.add(new CollectionTreeEdgeDefinition("collection3", null));

        Report report = generateReport(list, collections, 5);

        report.print();

    }

    public static void main(String[] args) {

        scenario0();

        scenario1();

        scenario2();

    }

}

class CollectionData {

    String id;

    long size;

    public CollectionData(String id, long size) {

        this.id = id;

        this.size = size;

    }

}

class Report {

    long totalSize;

    List<CollectionData> topCollectionsData;

    public Report(long totalSize, List<CollectionData> topCollectionsData) {

        this.totalSize = totalSize;

        this.topCollectionsData = topCollectionsData;

    }

    public void print() {

        System.out.println("Total file size: " + totalSize);

        topCollectionsData.forEach( a-> System.out.println(a.id + " has size "+ a.size));

    }

}

class FileMetadata {

    String name;

    long size;

    String collectionId;

    public FileMetadata(String name, long size, String collectionId) {

        this.name = name;

        this.size = size;

        this.collectionId = collectionId;

    }

}

class FileMetadata1 {

    String name;

    long size;

    List<String> collectionIds;

    public FileMetadata1(String name, long size, List<String> collectionIds) {

        this.name = name;

        this.size = size;

        this.collectionIds = collectionIds;

    }

}

class CollectionTreeEdgeDefinition {

    String id;

    String parentId;

    public CollectionTreeEdgeDefinition(String id, String parentId) {

        this.id = id;

        this.parentId = parentId;

    }

}