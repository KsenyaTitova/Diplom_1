package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    @Before
    public void set() {
        when(bun.getPrice()).thenReturn(100F);
        when(bun.getName()).thenReturn("Флюоресцентная булка");
        when(ingredient1.getPrice()).thenReturn(200F);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("Соус традиционный галактический");
        when(ingredient2.getPrice()).thenReturn(300F);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("Говяжий метеорит (отбивная)");
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals("Результат не совпал с ожидаемым", bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals("Результат не совпал с ожидаемым", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertEquals("Результат не совпал с ожидаемым", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        ingredient1 = new Ingredient(IngredientType.FILLING, ingredient1.getName(), ingredient1.getPrice());
        ingredient2 = new Ingredient(IngredientType.SAUCE, ingredient2.getName(), ingredient2.getPrice());
        List<Ingredient> expectedResult = List.of(ingredient2, ingredient1);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        List<Ingredient> actualResult = burger.ingredients;
        assertEquals("Результат не совпал с ожидаемым", expectedResult, actualResult);
    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        float actualResult = burger.getPrice();
        assertEquals("Результат не совпал с ожидаемым", 400F, actualResult, 0);
    }

    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        String actualResult = burger.getReceipt();
        String expectedResult = String.format("(==== Флюоресцентная булка ====)%n" +
                "= sauce Соус традиционный галактический =%n" +
                "= filling Говяжий метеорит (отбивная) =%n" +
                "(==== Флюоресцентная булка ====)%n" +
                "%n" + "Price: 700,000000%n");
        assertEquals("Результат не совпал с ожидаемым", expectedResult, actualResult);
    }
}