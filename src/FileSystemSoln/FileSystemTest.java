package FileSystemSoln;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FileSystemTest {
    FileSystem fileSystem;
    List<File> files;
    @Before
    public void setup(){
        fileSystem=new FileSystem();
        files= Arrays.asList
                (new File("File 1",10,"Collection 1"),
                        new File("File 2",10,null),
                        new File("File 3", 40,"Collection 2"),
                        new File("File 4",50,"Collection 3"));
    }
    @Test
    public void generateReportTest() throws Exception {
        List<String> res=Arrays.asList("Collection 3","Collection 2");
        Report report = fileSystem.generateReport(files, 2);
        assertEquals(110,report.totalFileSize);
        assertEquals(2,report.topNCollectionId.size());
        assertEquals(res,report.topNCollectionId);
    }
    @Test
    public void generateReportInvalidTest() throws Exception {
        Report report = fileSystem.generateReport(new ArrayList<>(), 2);
        assertNull(report);

        assertThrows(Exception.class,()->fileSystem.generateReport(files,5));

    }
}
