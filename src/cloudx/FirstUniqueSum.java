package cloudx;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstUniqueSum {

    public static void main(String[] args) {
        int[] case1 = new int[]{1, 31, 5, 5, 5, 27, 12, 26, 31, 12, 26, 3};
        assertEquals(getSum(case1), 31);

        int[] case2 = new int[]{2, 5, 5, 25, 25, 1, 2, 8, 31, 8};
        assertEquals(getSum(case2), 32);
        System.out.println("PASSED!");
    }

    private static <T> void assertEquals(T actual, T expected) {
        if (!Objects.equals(actual, expected)) {
            throw new IllegalStateException(String.format("Expected value: <%s> but was: <%s>", expected, actual));
        }
    }

    private static Integer getSum(int[] array) {
        Map<Integer, Integer> mapa = new HashMap<>();
        for (int num : array) {
            mapa.put(num, mapa.getOrDefault(num, 0) + 1);
        }
        //System.out.println(mapa);
        // Suma de no repetidos
        return mapa.entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .mapToInt(x -> x)
                .sum();
    }
}