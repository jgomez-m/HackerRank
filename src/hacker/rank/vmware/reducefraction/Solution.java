package hacker.rank.vmware.reducefraction;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Function to reduce a fraction to its lowest form
    public static List<String> reduceFraction(List<String> fractions)
    {
        List<String> answer = new ArrayList<>();
        for (String fraction : fractions) {
            int x = Integer.parseInt(fraction.split("/")[0]);
            int y = Integer.parseInt(fraction.split("/")[1]);
            String result = reduceAFraction(x,y);
            answer.add(result);
        }
        return answer;
    }

    private static String reduceAFraction(int x, int y){
        int denominator;
        denominator = gcd(x, y);
        x = x / denominator;
        y = y / denominator;

        return "" + x + "/" + y;
    }

    private static int gcd(int x, int y) {
        if (y == 0)
            return x;
        return gcd(y, x % y);
    }

    // Driver Code
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int fractionsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> fractions = IntStream.range(0, fractionsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = reduceFraction(fractions);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

}
