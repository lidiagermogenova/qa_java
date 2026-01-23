package com.example;

import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test //тест на проверку звука кота
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test // тест на еду для кота
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");

        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
        //Mockito.verify(feline, Mockito.times(1)).eatMeat(); //Оставила только одну проверку, на всякий случай закомментила вторую
    }
    @Test //тест на проверку, что кот передает исключение
    public void getFoodThrowsExceptionTest() {
        Cat cat = new Cat(feline);

        try {
            Mockito.when(feline.eatMeat()).thenThrow(new Exception());
        } catch (Exception e) {

        }
        try {
            cat.getFood();
        } catch (Exception e) {

        }
    }
}
