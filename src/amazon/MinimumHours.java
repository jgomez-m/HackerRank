package amazon;

import java.util.*;

public class MinimumHours {

    public int minimumHours(int rows, int columns, List<List<Integer>> grid) {
        Queue<int[]> q = new LinkedList<>();
        int target = grid.size() * grid.get(0).size();
        int cnt = 0, res = 0;
        for(int i=0; i<grid.size(); i++) {
            for(int j=0; j<grid.get(0).size(); j++) {
                if(grid.get(i).get(0) == 1) {
                    q.offer(new int[] { i,j } );
                    cnt++;
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
            int size = q.size();
            if(cnt == target)
                return res;
            for(int i=0;i<size;i++) {
                int[] cur = q.poll();
                for(int[] dir : dirs) {
                    int ni = cur[0] + dir[0];
                    int nj = cur[1] + dir[1];
                    if(ni >=0 && ni < grid.size() && nj >=0 && nj < grid.get(0).size() && grid.get(ni).get(nj) == 0) {
                        cnt++;
                        q.offer(new int[] {ni, nj});
                        grid.get(ni).set(nj, 1);
                    }
                }
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(0, 0, 0, 0),
                Arrays.asList(1, 1, 0, 1),
                Arrays.asList(1, 0, 0, 0),
                Arrays.asList(0, 1, 0, 0),
                Arrays.asList(1, 0, 1, 0)
        );
        int rows = grid.size();
        int columns = grid.get(0).size();
        System.out.println(new MinimumHours().minimumHours(rows, columns, grid));
    }
}
