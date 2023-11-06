import org.junit.jupiter.api.Test;
import org.lecture.FileReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileReaderTest {

    @Test
    public void testReadNumbersFromFile() {

        var numbers = FileReader.readNumbersFromFile();

        assertTrue(numbers != null && !numbers.isEmpty());

        assertTrue(numbers.contains(42));

        // Assert the size of the list
        assertEquals(100, numbers.size());
    }
}
