package hacker.rank.biggestTable;

public class Solution {

    int biggestTable(int [][] grid) {
        int max = 0;
        for(int x = 0; x < grid[0].length; x++) {
            for(int y= 0; y < grid.length; y++) {
            int table_size = biggestTableAt(x, y, grid);
                if (table_size > max) {
                    max = table_size;
                }
            }
        }
        return max;
    }

     int biggestTableAt(int x, int y, int[][] grid){
        int max = 0;
        for(int w = 1; w <= grid[0].length; w++) {
            for(int h = 1; h <= grid.length; h++) {
                int table_size = w * h;
                if (tableExist(grid, x, y, w, h) && table_size > max) {
                    max = table_size;
                }
            }
        }
        return max;
    }

     boolean tableExist(int[][] grid, int x, int y, int w, int h){
        boolean exist = true;
        for(int i = 0; i < w ; i++) {
            for(int j = 0; j < h ; j++) {
                if(j + y < grid.length && i + x < grid[0].length)
                    exist &= grid[j + y][i + x] == 1;
                else
                    return false;
            }
        }
        return exist;
    }

    /*You are again the owner of a coworking space like WeWork and your office building is rectangular.
    You team just created many wall partitions to create mini offices for startups. Your office campus
    is represented by a 2D array of 1s (floor spaces) and 0s (walls). Each point on this array is a one foot by
    one foot square. Before renting to tenants, you want to reserve an office for yourself. You wish to fit the largest
    possible rectangular table in your office, and you will select the office that fits this table. The table sides
    will always be parallel to the boundaries of the office building. What is the area of the biggest table that can
    fit in your office?
    Functions biggestTable() has one parameter:
    grid: a 2D grid/array of 1s and 0s
    Input Format For some of our templates, we have handled parsing for you. If we do not provide you a parsing function,
    you will need to parse the input directly. In this problem, our input format is as follows:
    The first line is the number of rows in the 2D array The second line is the number of columns in the 2D array
    The rest of the input contains the data to be processed Here is an example of the raw input:
    4
    5
    11110
    11010
    11000
    00000
    */

    public static void main(String[] args) {
        int [][] array = {{1, 0, 1, 1, 1},
                          {1, 0, 1, 1, 1},
                          {1, 1, 1, 1, 1},
                          {1, 0, 0, 1, 0}};
        int result = new Solution().biggestTable(array);
        System.out.println(result);
    }

}
