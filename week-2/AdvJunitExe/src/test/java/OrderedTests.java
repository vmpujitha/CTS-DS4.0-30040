import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void stepOne() {
        System.out.println("Step 1 executed");
        assertEquals(1, 1);
    }

    @Test
    @Order(2)
    void stepTwo() {
        System.out.println("Step 2 executed");
        assertTrue(true);
    }

    @Test
    @Order(3)
    void stepThree() {
        System.out.println("Step 3 executed");
        assertNotNull("JUnit");
    }
}
