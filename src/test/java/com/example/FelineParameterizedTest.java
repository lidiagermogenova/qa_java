package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {
    private final int inputKittens; // сколько котят передаем
    private final int expectedKittens; // сколько котят ожидаем

    public FelineParameterizedTest(int inputKittens, int expectedKittens) {
        this.inputKittens = inputKittens;
        this.expectedKittens = expectedKittens;
    }
    @Parameterized.Parameters(name = "Количество котят: input={0}, expected={1}") //добавила параметр name для большего понимания
    public static Collection<Object[]> data() { //данные для теста
        return Arrays.asList(new Object[][] {
                {0, 0},
                {1, 1},
                {3, 3},
                {5, 5},
        });
    }

    @Test
    public void getKittensWithCount() { //метод с параметром
        Feline feline = new Feline();

        int result = feline.getKittens(inputKittens);

        assertEquals(expectedKittens, result);
    }
}