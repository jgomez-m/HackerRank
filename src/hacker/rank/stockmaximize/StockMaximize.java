package hacker.rank.stockmaximize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


public class StockMaximize {

    private boolean test(){
        java.io.File f = new java.io.File("");
        boolean result = false;
        try{
            if(f.isDirectory()){
                f.delete();
                result = true;
            }
        } catch (Exception e){
            result = false;
        }
        return result;
    }
    
    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);
        int numOfTestCase = sc.nextInt();
        for (int i = 0; i < numOfTestCase; i++) {
            int n = sc.nextInt();
            long profit = 0;
            int[] stockPrice = new int[n];

            for (int j = 0; j < n; j++) {
                stockPrice[j] = sc.nextInt();
            }

            
            Collection<? extends Number> foo = new ArrayList<Number>();
            Integer x = 10;
            
            foo = null;
            int currMax = Integer.MIN_VALUE;

            for (int j = n - 1; j >= 0; j--) {
                if (currMax < stockPrice[j]) {
                    currMax = stockPrice[j];
                }
                profit += (currMax - stockPrice[j]);
            }
            System.out.println(profit);

        }
        sc.close();
    }
}