package hacker.rank.vmware.rodcutting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Result {

    /*
     * Complete the 'rodOffcut' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY lengths as parameter.
     */

    public static List<Integer> rodOffcut(List<Integer> lengths) {
        // Write your code here
        Collections.sort(lengths);
        List<Integer> answer = new ArrayList<>();
        int pos = 0;
        int remaining = lengths.size();
        while (0 < remaining) {
            //System.out.println(remaining);
            answer.add(remaining);
            int count = countEqualFrom(lengths, pos);
            pos += count;
            remaining -= count;
        }
        return answer;
    }

    private static int countEqualFrom(List<Integer> sticks, int from) {
        int value = sticks.get(from);
        for (int i = 1; from + i < sticks.size(); ++i) {
            if (value != sticks.get(from + i)) {
                return i;
            }
        }
        return sticks.size() - from;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<Integer> sticks = new ArrayList<>(num);
        for (int i = 0; i < num; ++i) {
            sticks.add(scanner.nextInt());
        }
        List<Integer> result = Result.rodOffcut(sticks);
        result.forEach(System.out::println);

        /**
         * Example of Input:
         * 6
         * 5 4 4 2 2 8
         */
    }
}
