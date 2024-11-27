import org.example.TriangleValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleValidatorTest {

    @ParameterizedTest
    @CsvSource({
        "3, 4, 5, true",
        "1, 1, 2, false",
        "0, 0, 0, false",
        "-1, -2, -3, false",
        "1073741823, 1073741823, 1073741823, true"
    })
    void testIsTriangle(int a, int b, int c, boolean expected) {
        Assertions.assertEquals(expected, TriangleValidator.isTriangle(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
        "3, 4, 5, Scalene",
        "1, 1, 1, Equilateral",
        "2, 2, 3, Isosceles",
        "10, 10, 1, Isosceles",
        "1, 2, 3, Invalid Triangle",
        "0, 0, 0, Invalid Triangle",
        "1073741823, 1073741823, 1073741823, Equilateral",
        "-1, -2, -3, Invalid Triangle",
    })
    void testDetermineTriangleType(int a, int b, int c, String expected) {
        Assertions.assertEquals(expected, TriangleValidator.determineTriangleType(a, b, c));
    }

    @Test
    void testInvalidInput() {
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("a"));
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("="));
    }
}
