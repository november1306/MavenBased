import api.RestTest;
import api.StarWarsApiTest;
import org.junit.platform.suite.api.*;


@Suite
@SuiteDisplayName("JUnit Platform Suite Demo")

@SelectClasses({RestTest.class, StarWarsApiTest.class})
@IncludeTags({"smoke", "selenium"})
//@IncludeClassNamePatterns(".*Tests")
//@SelectPackages("examples")

public class SuitTest {
}

