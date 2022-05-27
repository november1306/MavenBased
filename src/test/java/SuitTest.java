import api.RestTest;
import api.StarWarsApiTest;
import org.junit.platform.suite.api.*;


@Suite
@SuiteDisplayName("JUnit Platform Suite Demo")

//@SelectClasses({RestTest.class, StarWarsApiTest.class})
//@IncludeTags("selenium")
//@IncludeClassNamePatterns(".*Tests")
@SelectPackages("automationpractice")

public class SuitTest {
}

