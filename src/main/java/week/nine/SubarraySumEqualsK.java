package week.nine;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XiongShiyu
 * @description SubarraySumEqualsK
 * @date 2022/6/19 22:13
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumNums = new HashMap();
        int sum = 0;
        sumNums.put(0, 1);
        int ret = 0;
        for (int i = 0; i < nums.length;i++) {
            sum = sum + nums[i];
            int num = sumNums.getOrDefault(sum - k, 0);
            ret += num;
            int sumNum = sumNums.getOrDefault(sum, 0) + 1;
            sumNums.put(sum, sumNum);
        }
        return ret;
    }
}
