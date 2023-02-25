import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itis.dictionary.map.CoolMap;
import ru.itis.dictionary.map.CoolMapImpl;

public class CoolMapTests {
    CoolMap<String, String > map;

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Begin of testing");
    }

    @BeforeEach
    void beforeEachTest() {
        map = new CoolMapImpl<>();
    }

    @Test
    void checkAddSizeClear() {
        map.put("1", "One");
        map.put("2", "Two");
        map.put("3", "Three");
        Assertions.assertEquals("One", map.get("1"));
        map.put("1", "Один");
        Assertions.assertEquals("Один", map.get("1"));
    }
}
