package week.eight;

/**
 * @author XiongShiyu
 * @description RedundantConnection
 * @date 2022/6/12 21:31
 */
public class RedundantConnection {

    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        for(int i = 0; i < parent.length -1; i++) {
            parent[i] = i;
        }
        for(int[] edge : edges) {
            if(find(edge[0]) == find(edge[1])) {
                return edge;
            }else{
                union(edge[0], edge[1]);
            }
        }
        return null;
    }

    private void union (int value1, int value2) {
        parent[find(value2)] = find(value1);
    }

    private int find (int value) {
        if(value == parent[value]) {
            return value;
        }else{
            parent[value] = find(parent[value]);
            return parent[value];
        }
    }
}
