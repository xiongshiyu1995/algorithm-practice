package week.two;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XiongShiyu
 * @description DegreeOfAnArray
 * @date 2022/4/24 23:03
 */
public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap(16);
        for(int i = 0; i < nums.length; i++) {
            int[] flags = map.getOrDefault(nums[i], new int[3]);
            if(flags[0] == 0) {
                flags[1] = i;
            }
            flags[0]++;
            flags[2] = i;
            map.put(nums[i], flags);
        }
        Integer ret = nums.length;
        Integer time = 0;
        for(Map.Entry<Integer, int[]> entry : map.entrySet()) {
            if(entry.getValue()[0] > time ||
                    (entry.getValue()[0] == time && entry.getValue()[2] - entry.getValue()[1] + 1 < ret)) {
                ret = entry.getValue()[2] - entry.getValue()[1] + 1;
                time = entry.getValue()[0];
            }
        }
        return ret;
    }
}
