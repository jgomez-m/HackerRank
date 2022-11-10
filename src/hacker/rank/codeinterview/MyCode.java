package hacker.rank.codeinterview;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Write a program that parses a sentence and replaces each word with the following:
1) The first letter of the word
2) The number of distinct characters between first and last character
3) The last letter of the word.
For example, Smooth would become S3h.
Words are separated by spaces or non-alphabetic characters and these separators should be maintained in their original form and location in the answer.
A few of the things we will be looking at is accuracy, efficiency, solution completeness.
*/
class MyCode {
    public static String wordParser(String input) {
        // IMPLEMENT YOUR SOLUTION HERE
        String[] tokens = input.split(" ");
        String convertedString = "";
        for (int i = 0; i<tokens.length; i++){
            if(tokens[i].length() > 2) {

                convertedString = convertedString + " " + handleAWord(tokens[i]);
            }
            else {
                convertedString = convertedString + " "+ tokens[i];
            }
        }
        return convertedString;
    }

    private static String handleAWord(String word) {
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(word);
        boolean b = m.find();
        // Letter with special character
        if(b){
            return  wordWithCaracter(word);
        }
        //Letter without special character
        else{
            return normalWord(word);
        }
    }

    private static String wordWithCaracter(String word){

        String letterCoding="";

        String letterComplete="";
        ArrayList<String> letterCompleted = new ArrayList<>();
        String specialCharacters=" !#$%&'()*+,-./:;<=>?@[]^_`{|}~";

        //Scan the word from left to right
        for(int k = 0 ; k<word.length() ; k++){
            if(!Character.isAlphabetic(word.charAt(k))){
                letterCompleted.add(letterComplete);
                letterComplete = "";
                letterCompleted.add(word.charAt(k)+"");
            }
            // Alphabetic
            else{
                letterComplete = letterComplete + "" + word.charAt(k);
                if(k == word.length()-1){
                    letterCompleted.add(letterComplete);
                    letterComplete="";
                }
            }
        }

        for(int i = 0; i<letterCompleted.size() ; i++){
            if(specialCharacters.contains(String.valueOf(letterCompleted.get(i)))){
                letterCoding = letterCoding+""+letterCompleted.get(i);
            }else{
                if(letterCompleted.get(i).length() > 2){
                    letterCoding = letterCoding+""+normalWord(letterCompleted.get(i));
                }else{
                    letterCoding = letterCoding+""+letterCompleted.get(i);
                }
            }
        }

        return letterCoding;
    }

    private static String normalWord(String word){
        String tempWord = word.substring(1,word.length()-1);
        List<String> letras = new ArrayList<>();

        for(int j=0; j < tempWord.length(); j++ ){
            letras.add(String.valueOf(tempWord.charAt(j)));
        }
        Set<String> hashSet = new HashSet<String>(letras);
        letras.clear();
        letras.addAll(hashSet);
        return word.charAt(0)+""+hashSet.size()+""+word.charAt(word.length()-1);
    }

    public static void main (String[] args) {
        String output = wordParser("Creativity is thinking-up new things. Innovation is doing new things!");
        System.out.println(output);
        // expected: C6y is t4g-up n1w t4s. I6n is d3g n1w t4s!
    }
}
