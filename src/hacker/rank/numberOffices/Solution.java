package hacker.rank.numberOffices;

import java.util.Scanner;

class Solution
{
    static int ROW;
    static int COLUMN;
    static int[] rowNeighbors = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] colNeighbors = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static int numOffices(String[][] grid) {
        int result=0;
        ROW = grid.length;
        COLUMN = grid[0].length;
        boolean visited[][] = new boolean[ROW][COLUMN];

        for(int i=0; i<ROW; i++){
            for(int j=0; j<COLUMN; j++){
                if(grid[i][j].equals("1") && !visited[i][j]){
                    DFS(grid, i, j, visited);
                    result++;
                }
            }
        }
        return result;
    }

    static void DFS(String[][] grid, int row, int col, boolean visited[][]){
        visited[row][col] = true;

        for (int k = 0; k < 8; k++) {
            if (isSafe(grid, row + rowNeighbors[k], col + colNeighbors[k], visited)){
                DFS(grid, row + rowNeighbors[k], col + colNeighbors[k], visited);
            }
        }
    }

    static boolean isSafe(String grid[][], int row, int column, boolean visited[][]){
        return (row >= 0) && (row < ROW) && (column >= 0) && (column < COLUMN)
                && (grid[row][column].equals("1") && !visited[row][column]);
    }
}

class Rextester
{
    public static String[][] getMatrix() {
        Scanner sc = new Scanner(System.in);
        int rowsLen = sc.nextInt();
        int colsLen = sc.nextInt();
        String matrix[][] = new String[rowsLen][colsLen];
        int i;
        for(i=0;i<rowsLen;i++){
            String line = sc.next();
            for(int j=0;j<line.length();j++) {
                matrix[i][j] = String.valueOf(line.charAt(j));
            }
        }
        return matrix;
    }
    /*
    You are the owner of a coworking space like WeWork and your office building is rectangular. Your team just built
    wall partitions to create mini offices for startups. This office campus is represented by a 2D array of 1s
    (floor spaces) and 0s (walls). Each point on this array is a one foot by one foot square. You need to calculate
    the number of offices. A single office is bordered by walls and is constructed by placing floors next to each other,
    horizontally and/or vertically. Two 1s adjacent to each other horizontally or vertically are always part of the same office.

    Function numOffices() has one parameter: grid - a 2D grid/array of 1s and 0s

    In this problem, our input format is as follows: The first line is the number of rows in the 2D array. The second
    line is the number of columns in the 2D array. The rest of the input contains the data to be processed.
    */

    public static void main(String args[])
    {
        int result = Solution.numOffices(getMatrix());
        System.out.println(result);
    }
}