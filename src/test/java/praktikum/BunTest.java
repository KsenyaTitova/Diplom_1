package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {

    Bun bun = new Bun("Флюоресцентная булка", 1000);

    @Test
    public void getName() {
        String expectedResult = "Флюоресцентная булка";
        assertEquals("Результат не совпал", expectedResult, bun.getName());
    }

    @Test
    public void getPrice() {
        float expectedResult = 1000;
        assertEquals(expectedResult, bun.getPrice(), 0);
    }
}