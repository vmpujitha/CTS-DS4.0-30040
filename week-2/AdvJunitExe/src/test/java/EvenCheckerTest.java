import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {

    EvenChecker checker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 10, 100})
    void testIsEvenTrue(int input) {
        assertTrue(checker.isEven(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 7, 11, 99})
    void testIsEvenFalse(int input) {
        assertFalse(checker.isEven(input));
    }
}
