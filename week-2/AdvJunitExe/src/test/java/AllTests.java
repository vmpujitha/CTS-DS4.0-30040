import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({FirstTest.class, SecondTest.class})
public class AllTests {
    // Empty class, used for grouping test cases
}