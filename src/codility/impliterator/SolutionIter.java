package codility.impliterator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



class SolutionIter implements Iterable<Integer> {

    private BufferedReader reader;
    
    public SolutionIter(Reader inp){
        reader = new BufferedReader(inp);
    }

    @Override
    public Iterator<Integer> iterator(){
        List<Integer> resp = new ArrayList<Integer>();
        try {
            if(reader!= null){
                String line = null;
                while((line = reader.readLine()) !=null){
                    if(validInteger(line)){
                        resp.add(Integer.parseInt(line));
                    }
                }
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return resp.iterator();
    }
    
    private boolean validInteger(String line) {
        if(line!=null && line.isEmpty()){
            return false;
        }
        try{
            line = line.trim();
            Integer tmp = Integer.parseInt(line);
            if(tmp >= -1000000000 && tmp<= 1000000000){
                return true;
            }
        }catch(NumberFormatException e){
            return false;
        }
        return false;
    }

    public static void main(String[] args){
        Reader reader = null;;
        try {
            reader = new InputStreamReader(new FileInputStream(""));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (Integer x : new SolutionIter(reader)) {
                 System.out.println(x);
        }
    }
}

/**
 * Example usage:
 *
 * for (Integer x : new codility.impliterator.SolutionIter(reader)) {
 *     System.out.println(x);
 * }
 */

