package week.four;

import java.util.Arrays;

/**
 * @author XiongShiyu
 * @description ShipWithinDays
 * @date 2022/5/16 1:10
 */
public class ShipWithinDays {

    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            int needDay = 1;
            int sum = 0;
            for (int weight: weights) {
                if(sum + weight > mid) {
                    needDay++;
                    sum = weight;
                }else{
                    sum += weight;
                }
            }
            if (needDay <= days) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
