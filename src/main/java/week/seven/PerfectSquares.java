package week.seven;

/**
 * @author XiongShiyu
 * @description PerfectSquares
 * @date 2022/6/5 22:11
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for(int i = 1; i < n + 1; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                min = Math.min(min, f[i - j * j]);
            }
            f[i] = min + 1;
        }
        return f[n];
    }
}
