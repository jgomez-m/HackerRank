package hacker.rank.exceptions2;

import java.util.*;


public class Solution { 
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        myCalculator calc = new myCalculator();
        while(sc.hasNext()){
            int n = sc.nextInt();
            int p = sc.nextInt();
            try {
                int res = calc.power(n, p);
                System.out.println(res);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class myCalculator{
      
      int power(int n,int p) throws Exception
      {
          if(n<0 || p<0) throw new Exception("n and p should be non-negative");
          if(p==0) return 1;
          return n*power(n,p-1);
      }
}
