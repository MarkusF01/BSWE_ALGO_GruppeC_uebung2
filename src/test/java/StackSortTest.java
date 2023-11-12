import org.junit.jupiter.api.Test;
import org.lecture.FileReader;
import org.lecture.StackSort;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackSortTest {


    @Test
    public void testIsInteger() {
        StackSort stackSort = new StackSort();

        // Valid integers
        assertEquals(true, stackSort.isInteger("123"));
        assertEquals(true, stackSort.isInteger("-456"));

        // Invalid integers
        assertEquals(false, stackSort.isInteger("abc"));
        assertEquals(false, stackSort.isInteger("12.34"));
    }

    @Test
    public void testReadNumbersFromFile() {
        List<Integer> expectedNumbers = Arrays.asList(
                95, 56, 23, 12, 64, 85, 38, 14, 96, 22,
                7, 69, 79, 100, 43, 45, 11, 92, 55, 83,
                8, 74, 81, 4, 65, 97, 62, 98, 84, 47, 13,
                78, 42, 41, 76, 49, 5, 39, 6, 60, 67, 87,
                33, 20, 89, 15, 61, 29, 9, 93, 90, 57, 70,
                53, 1, 40, 46, 94, 59, 18, 27, 68, 28, 24,
                82, 31, 66, 16, 30, 21, 32, 51, 26, 35, 48,
                2, 75, 88, 10, 17, 37, 44, 36, 25, 19, 63,
                34, 50, 71, 91, 3, 73, 86, 52, 80, 77, 72,
                58, 54, 99
        );

        List<Integer> actualNumbers = FileReader.readNumbersFromFile();

        assertEquals(expectedNumbers, actualNumbers);
    }
}
