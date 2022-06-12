package week.eight;

/**
 * @author XiongShiyu
 * @description NumberOfIslands
 * @date 2022/6/12 22:36
 */
public class NumberOfIslands {

    private String[][] parents;

    private int count;

    public int numIslands(char[][] grid) {
        count = grid.length * grid[0].length;
        parents = new String[grid.length][grid[0].length];
        for(int i = 0; i < parents.length; i++) {
            for(int j = 0; j < parents[0].length; j++) {
                parents[i][j] = String.valueOf(i) + ":" + String.valueOf(j);
            }
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    if(i + 1 < grid.length && grid[i + 1][j] == '1') {
                        union(i, j, i + 1, j);
                    }
                    if(j + 1 < grid[0].length && grid[i][j + 1] == '1') {
                        union(i, j, i, j + 1);
                    }
                }else{
                    count--;
                }
            }
        }
        return count;
    }

    private void union(int i1, int j1, int i2, int j2) {
        String s1 = find(i1, j1);
        String s2 = find(i2, j2);
        if(!s1.equals(s2)) {
            String[] s2Array = s2.split(":");
            int newI = Integer.parseInt(s2Array[0]);
            int newY = Integer.parseInt(s2Array[1]);
            parents[newI][newY] = s1;
            count--;
        }
    }

    private String find(int i, int j) {
        String value = String.valueOf(i) + ":" + String.valueOf(j);
        if(value.equals(parents[i][j])) {
            return value;
        }else{
            String[] s = parents[i][j].split(":");
            int newI = Integer.parseInt(s[0]);
            int newY = Integer.parseInt(s[1]);
            return parents[i][j] = find(newI, newY);
        }
    }
}
