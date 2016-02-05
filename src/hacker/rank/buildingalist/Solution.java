package hacker.rank.buildingalist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Arun.G
 * 
 */
public class Solution {
    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter out;
    private StringBuilder output = new StringBuilder();
    String inputstring = "";

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            out = new PrintWriter(System.out);
            solve();
            reader.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void combine(int start) {
        for (int i = start; i < inputstring.length(); ++i) {
            output.append(inputstring.charAt(i));

            if (!output.equals(""))
                System.out.println(output);

            if (i < inputstring.length())
                combine(i + 1);
            output.setLength(output.length() - 1);
        }
    }

    private void solve() throws IOException {

        int T = nextInt();

        for (int count = 0; count < T; count++) {
            nextInt(); // to get N value, but it is used
            inputstring = nextToken();
            combine(0);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}