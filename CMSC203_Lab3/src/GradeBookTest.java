import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

    private GradeBook gb1;
    private GradeBook gb2;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        // Can be left empty if nothing needed before all tests
    }

    @BeforeEach
    void setUp() throws Exception {
        // Create two GradeBook objects with capacity for 5 scores
        gb1 = new GradeBook(5);
        gb2 = new GradeBook(5);

        // Add scores to gb1
        gb1.addScore(85.5);
        gb1.addScore(92.0);
        gb1.addScore(76.5);

        // Add scores to gb2
        gb2.addScore(88.0);
        gb2.addScore(90.5);
    }

    @AfterEach
    void tearDown() throws Exception {
        // Set GradeBook objects to null
        gb1 = null;
        gb2 = null;
    }

    @Test
    void testAddScore() {
        // Check scores content with toString
        assertTrue(gb1.toString().equals("85.5 92.0 76.5"));
        assertTrue(gb2.toString().equals("88.0 90.5"));

        // Check scoresSize
        assertEquals(3, gb1.getScoreSize());
        assertEquals(2, gb2.getScoreSize());
    }

    @Test
    void testSum() {
        assertEquals(85.5 + 92.0 + 76.5, gb1.sum(), 0.001);
        assertEquals(88.0 + 90.5, gb2.sum(), 0.001);
    }

    @Test
    void testMinimum() {
        assertEquals(76.5, gb1.minimum(), 0.001);
        assertEquals(88.0, gb2.minimum(), 0.001);
    }

    @Test
    void testFinalScore() {
        // finalScore drops lowest if 2+ scores
        assertEquals(85.5 + 92.0, gb1.finalScore(), 0.001); // 76.5 dropped
        assertEquals(90.5, gb2.finalScore(), 0.001);         // 88.0 dropped
    }

    @Test
    void testGetScoreSize() {
        assertEquals(3, gb1.getScoreSize());
        assertEquals(2, gb2.getScoreSize());
    }

    @Test
    void testToString() {
        assertEquals("85.5 92.0 76.5", gb1.toString());
        assertEquals("88.0 90.5", gb2.toString());
    }
}
