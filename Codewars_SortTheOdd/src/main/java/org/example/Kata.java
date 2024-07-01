package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Kata {
    public static int[] sortArray(int[] array) {
        //Extract and sort odd numbers
        List<Integer> sortedOdds = Arrays.stream(array)
                .filter(n -> n % 2 !=0)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        //Copy the original array
        int[] result = array.clone();

        //Iterator
        int oddIndex = 0;

        //Substitute odd number by sorted values. If number is not odd, iterate to next level and check next number. Each time the number is odd, get number from []result by oddIndex and THEN ++ (raise oddIndex by 1).
        for (int i = 0; i < result.length; i++) {
            if (result[i] % 2 !=0){
                result[i] = sortedOdds.get(oddIndex++); //use number by oddIndex from []result and then raise up oddIndex by 1 (++)
            }
        }

        return result;
    }
}



/*
TESTING


import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.junit.runners.JUnit4;

public class SolutionTest {

    @Test
    public void exampleTest1() {
        assertArrayEquals(new int[]{ 1, 3, 2, 8, 5, 4 }, Kata.sortArray(new int[]{ 5, 3, 2, 8, 1, 4 }));
    }

    @Test
    public void exampleTest2() {
        assertArrayEquals(new int[]{ 1, 3, 5, 8, 0 }, Kata.sortArray(new int[]{ 5, 3, 1, 8, 0 }));
    }

    @Test
    public void exampleTest3() {
        assertArrayEquals(new int[]{}, Kata.sortArray(new int[]{}));
    }
}
 */