package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class LionTest {
    @Mock
    private Feline feline;

    @Test
    public void maleLionTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }
    @Test
    public void femaleLionTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }
    @Test
    public void invalidSexThrowsExceptionTest() {
        boolean exceptionThrown = false;

        try {
            new Lion("Неизвестно", feline);
        } catch (Exception e) {
            exceptionThrown = true;
        }
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        Assert.assertTrue("Исключение должно было быть выброшено", exceptionThrown);
    }
    @Test
    public void getKittenTest() throws Exception {

        Lion lion = new Lion("Самец", feline);

        Mockito.when(feline.getKittens()).thenReturn(3);
        int kittens = lion.getKittens();

        assertEquals(3, kittens);
    }

    @Test
    public void getFoodTest() throws Exception {

        Lion lion = new Lion("Самец", feline);

        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
    }
    @Test
    public void doesHaveManeForMaleTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }
    @Test
    public void doesHaveManeForFemaleTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }
}
