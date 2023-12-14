package tests.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"tests.cucumber.stepDefinitions", "tests.cucumber.hooks", "tests.cucumber.dataContext"},
        monochrome = true,
        plugin = {"pretty", "html:target/site/cucumber-report-default.html", "json:target/site/cucumber.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@login"
)

//@Test
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}

