package hacker.rank.vmware.fillingjars;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) throws Exception  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s [] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int a[] = new int[m];
        int b[] = new int[m];
        int k[] = new int[m];
        for(int i=0;i<m;i++){
            s = br.readLine().split(" ");
            a[i] = Integer.parseInt(s[0]);
            b[i] = Integer.parseInt(s[1]);
            k[i] = Integer.parseInt(s[2]);
        }
        calculateAverage(n, m, a, b, k);

        /**
         * Example of Input:
         * 5 3
         * 1 2 100
         * 2 5 100
         * 3 4 100
         *
         * Result:
         * 160
         */

    }

    private static void calculateAverage(int n, int m, int[] a, int[] b, int[] k) {
        BigInteger su = BigInteger.valueOf(0);
        for(int i = 0; i< m; i++){
            int l = b[i]- a[i]+1;
            su = su.add(BigInteger.valueOf(k[i]).multiply(BigInteger.valueOf(l)));
        }
        su = su.divide(BigInteger.valueOf(n));
        System.out.println(su);
    }
}
