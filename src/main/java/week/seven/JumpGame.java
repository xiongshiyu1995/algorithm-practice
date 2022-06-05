package week.seven;

/**
 * @author XiongShiyu
 * @description JumpGame
 * @date 2022/6/5 21:28
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int index = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(i + nums[i] >= index) {
                index = i;
            }
        }
        return index == 0 ? true : false;
    }
}
