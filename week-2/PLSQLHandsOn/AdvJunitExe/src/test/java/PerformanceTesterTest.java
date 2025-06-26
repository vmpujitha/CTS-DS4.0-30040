import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTesterTest {

    @Test
    void testTaskWithinTime() {
        PerformanceTester tester = new PerformanceTester();
        assertTimeout(Duration.ofMillis(200), () -> tester.performTask());
    }
}
