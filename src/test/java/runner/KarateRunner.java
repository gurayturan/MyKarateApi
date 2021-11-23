package runner;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertTrue;
//DO NOT USE @ RUN WITH(Karate.class)
//@RunWith(Karate.class)
@KarateOptions(features = "classpath:features",
tags = {"@gry"})
public class KarateRunner {

    @BeforeClass
    public static void before() {
        System.setProperty("karate.env", "STG");
    }


    @Test
    public void testParallel() {
        //System.setProperty("karate.env", "demo"); // ensure reset if other tests (e.g. mock) had set env in CI
        // Specify your feature here
       // Results results = Runner.path("classpath:features").tags("@tagGry,~@ignore").parallel(5);
        // generateReport(results.getReportDir());
        // assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
        Results results = Runner.parallel(getClass(), 5);
        generateReport(results.getReportDir());
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }
    // Generate report method to generate the report
    public static void generateReport(String karateOutputPath) {
        System.out.println("path"+karateOutputPath);
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
//Specify the folder where to want to generate the feature file
        Configuration config = new Configuration(new File("target"), "Karate API");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }

}