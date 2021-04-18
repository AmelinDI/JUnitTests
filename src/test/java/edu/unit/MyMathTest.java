package edu.unit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;


class MyMathTest {

    private final MyMath myMath = new MyMath();
    int apiVersion = 11;

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach test");
    }


    @Test
    void testOnArrayItems() {
        Integer[][] numbers = new Integer[][]{{1,2,3},{2,3,5},{3,4,7}};

        // vers.1 (All)
        assertAll(
                ()->assertEquals(numbers[0][2], myMath.add(numbers[0][0],numbers[0][1])),
                ()->assertEquals(numbers[1][2], myMath.add(numbers[1][0],numbers[1][1])),
                ()->assertEquals(numbers[2][2], myMath.add(numbers[2][0],numbers[2][1]))
        );

        // vers.2 (stream)
        Arrays.stream(numbers).forEach(c->assertEquals(c[2], myMath.add(c[0],c[1])));
        Arrays.stream(numbers).forEach(c -> System.out.println(c[0]+" + "+c[1]+" = "+c[2]));
    }


    @Test
    @DisplayName("test for Exception in 'div'")
    void exceptionTest() {
        assertThrows(IllegalArgumentException.class, ()->myMath.div(9,0));
    }


    @ParameterizedTest
    @DisplayName("test for odd numbers")
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        Assumptions.assumeTrue(apiVersion>10);
        assertTrue(number % 2 != 0);
    }

}