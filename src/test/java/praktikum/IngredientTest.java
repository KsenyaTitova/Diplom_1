package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTest {

    private final String name = "Биокотлета из марсианской Магнолии";
    private final float price = 500F;
    Ingredient ingredient = new Ingredient(IngredientType.FILLING, name, price);

    @Test
    public void getPrice() {
        assertEquals("Результат не совпал", price, ingredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        assertEquals("Результат не совпал", name, ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals("Результат не совпал", IngredientType.FILLING, ingredient.getType());
    }
}