import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestMP3 {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void test1() {
        Employee franklin = new Employee("Franklin Wong", "CRADO", "R&D", 160000, "male", true);
        Employee john = new Employee("John Smith", "Research Assistant", "R&D", 120000, "male", true);
        Employee ramesh = new Employee("Ramesh Narayan", "Data Scientist", "R&D", 120000, "male", false);

        franklin.addOverseen(john);
        franklin.addOverseen(ramesh);
        YellowCoats yc = new YellowCoats(franklin);
        yc.addEmployee(ramesh, john);

        assertEquals(franklin.getOverseen(0), john);
        assertEquals(franklin.getOverseen(1), ramesh);
    }

    @Test
    public void test2() {
        Employee franklin = new Employee("Franklin Wong", "CRADO", "R&D", 160000, "male", true);
        Employee john = new Employee("John Smith", "Research Assistant", "R&D", 120000, "male", true);
        Employee ramesh = new Employee("Ramesh Narayan", "Data Scientist", "R&D", 120000, "male", false);

        franklin.addOverseen(john);
        franklin.addOverseen(ramesh);
        franklin.print4();

        assertEquals("R&D: $133333.33333333334", outContent.toString().trim());
    }

    @Test
    public void test3() {
        Employee franklin = new Employee("Franklin Wong", "CRADO", "R&D", 160000, "male", true);
        Employee john = new Employee("John Smith", "Research Assistant", "R&D", 120000, "male", false);
        franklin.addOverseen(john);
        franklin.print2();

        assertEquals("Franklin Wong, CRADO, R&D, $160000, male, true", outContent.toString().trim());
    }

    @Test
    public void test4() {
        Employee franklin = new Employee("Franklin Wong", "CRADO", "R&D", 160000, "male", true);
        franklin.print1();

        assertEquals("Franklin Wong, CRADO, R&D, $160000, male, true", outContent.toString().trim());
    }
}