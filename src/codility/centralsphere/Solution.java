package codility.centralsphere;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int solution(Point3D[] Array) {
        Set<Integer> listOfSum = new HashSet<>();
        for(Point3D point : Array){
            int sumQuad = sumQuad(point);
            listOfSum.add(sumQuad);
        }
        return listOfSum.size();
    }

    private int sumQuad(Point3D P){
        return (int) (Math.pow(P.x, 2) + Math.pow(P.y, 2) + Math.pow(P.z, 2));
    }

    public static void main(String args[]) {

    }
}

class Point3D {
    public int x;
    public int y;
    public int z;
}