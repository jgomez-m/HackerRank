package hacker.rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static Integer divisible_by_7( Integer[] my_list ) {
        //Insert your code here
        int count = 0;
        for(Integer num : my_list){
            if(num >= 77){
                return 0;
            }
            if(num == 0 || num %7 ==0){
                count++;
            }
        }
        return count;

    }

    public static String average( String[] students ) {
        return Arrays.stream(students).map(x -> x.split(" "))
                .map(x -> String.format("%s - %s: %s", x[0], x[1], calculateAverage(x)))
                .collect(Collectors.joining(";"));
    }

    public static int calculateAverage(String [] studentMarks) {
        int average = 0;
        List<Integer> numbers = new ArrayList<>();
        for(int i = 2; i<studentMarks.length; i++){
            if(Integer.parseInt(studentMarks[i]) > 0 && Integer.parseInt(studentMarks[i]) <= 10) {
                numbers.add(Integer.parseInt(studentMarks[i]));
            }
        }
        return (int) numbers.stream().mapToInt(x -> x).average().getAsDouble();
    }

    public static Boolean isValidPassword( String password ) {
        if(password.length() < 8)
            return false;
        for(char ch: password.toCharArray()) {
            if((ch == ','))
            return false;
        }
        boolean hasUppercases = false;
        boolean hasLowercases = false;
        boolean hasDigits = false;
        int specialChars = 0;
        for(int i = 0, n = password.length() ; i < n ; i++) {
            char c = password.charAt(i);
            if(Character.isDigit(c)) {
                hasDigits = true;
            } else if(Character.isUpperCase(c)) {
                hasUppercases = true;
            } else if(Character.isLowerCase(c)) {
                hasLowercases = true;
            } else {
                specialChars++;
            }
        }
        if(specialChars == 0 || specialChars > (password.length()*20/100)) {
            return false;
        }


        for(int i = 0; i < password.length() - 3; i++) {
            if(((int)password.charAt(i)+1 == (int)password.charAt(i+1))&&
                    ((int)password.charAt(i+1)+1 == (int)password.charAt(i+2))) {
                return false;
            }
        }

        if(hasUppercases&&hasLowercases&&hasDigits&&(specialChars > 0)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
//        boolean res = Divisible.isValidPassword("123@PaSS");
//        System.out.println("res = " + res);
        String resultAverage = Solution.average(new String [] {"Julian Gomez 10 10 10 10", "Name lastName 2 3 2 4 5 10 2 -1"});
        System.out.println("resultAverage = " + resultAverage);
    }

}
