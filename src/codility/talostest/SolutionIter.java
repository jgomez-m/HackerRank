package codility.talostest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SolutionIter implements Iterable<Integer> {

    private List<Integer> resultList = new ArrayList<>();

    public SolutionIter(Reader reader) throws IllegalArgumentException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = "";
        try {
            while((line = bufferedReader.readLine()) != null) {
                if(isValid(line)) {
                    String temp = line.replaceAll(" ", "").trim();
                    int number = Integer.parseInt(temp);
                    if(number >= -100000000 && number <= 1000000000) {
                        resultList.add(number);
                    }
                }
            }
        } catch (IOException e) {
            System.out.print("Error Reading the Input");
        }
        
    }

    private boolean isValid(String line) {
        String validExp = "[\\s]*[-+]?[0-9]+[\\s]*";
        return line.matches(validExp);
    }


    @Override
    public Iterator<Integer> iterator(){
        return resultList.iterator();
    }

    public static void main(String args[]){

        Reader reader = null;
        try {
            reader = new FileReader("C:/temp/test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Integer x : new SolutionIter(reader)) {
           System.out.println(x);
       }
    }
}
