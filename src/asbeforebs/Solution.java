package asbeforebs;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// "aaabb" should return true
// "ba" returns false
// "aaa" returns true
// "b" returns true


class Solution {
    public boolean solution(String S) {
        // write your code in Java SE 8
        char[] chars = S.toCharArray();
        boolean answ = true;
        boolean x = true;
        boolean y = false;
        int l = chars.length - 1;
        int i = 0;

        while(l>=0) {
            if (chars[0] == 'a') {
                x = false;
                i+= 1;
                l-= 1;
                if(!x && y) {
                    answ = false;
                    break;
                }
            }
            else if(chars[i] == 'b'){
                y=true;
                i+=1;
                l-=1;
            }
        }
        return answ;
    }
}
