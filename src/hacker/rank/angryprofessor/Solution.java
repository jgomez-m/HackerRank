package hacker.rank.angryprofessor;

import java.util.Scanner;

/**
 * @author Arun.G
 *
 */
public class Solution {

       /**
        * @param args
        */
       public static void main(String[] args) {
              // TODO Auto-generated method stub
               Scanner sc = new Scanner(System.in);
               //no of test cases
               int T = Integer.parseInt(sc.nextLine());
             
               for(int count=0;count<T;count++)
                   {
                       String[] constraints = sc.nextLine().split(" ");
                       //n and k
                   int N =Integer.parseInt(constraints[0]);
                   int K =Integer.parseInt(constraints[1]);
                   //count no of students inside the class
                   int noOfStuds =0;
                   //all the students times are stored in string array
                   String[] students = sc.nextLine().split(" ");
                  
                   for(int i=0;i<N;i++)
                       {
                       int stud = Integer.parseInt(students[i]);
                       // if it is negative or zero the student arrived before the class
                       if(stud<=0)
                           noOfStuds++;
                       //k students are present in the class so no need to cancel the class, so NO
                       if(noOfStuds>=K)
                           {
                           System.out.println("NO");
                           break;
                       }
                   }
                   // if K students are not there in the class the class is cancelled so YES
                   if(noOfStuds<K)
                       System.out.println("YES");
               }
               
               sc.close();
        
       }

}
