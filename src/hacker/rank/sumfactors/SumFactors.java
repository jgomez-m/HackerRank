package hacker.rank.sumfactors;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SumFactors {
    /*
     * Complete the 'maxSubsetSum' function below.
     *
     * The function is expected to return a LONG_INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY k as parameter.
     */

    public static List<Integer> maxSubsetSum(List<Integer> list) {
        // Write your code here
        return list.stream().map(SumFactors::sumFactors).collect(toList());

    }

    private static Integer sumFactors(Integer num) {
        int res = 0;
        for(int i=2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                if(i == (num/i)) {
                    res += i;
                }
                else {
                    res += (i + num / i);
                }
            }
        }
        return (res + num + 1);
    }

    public static void main(String[] args) {
        System.out.println(SumFactors.maxSubsetSum(List.of(2,4,9)));
    }
}
