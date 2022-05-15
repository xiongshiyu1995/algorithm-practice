package week.four;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author XiongShiyu
 * @description SlidingWindowMaximum
 * @date 2022/5/16 0:25
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<Integer>();
        int end = k - 1;
        for(int i =  0; i <= end; i++) {
            while(deque.peekLast() != null && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
        }
        int[] maxArray = new int[nums.length - k + 1];
        for(int i = end; i < nums.length; i++) {
            int index = deque.peek();
            maxArray[i - (k - 1)] = nums[index];
            if(index == i - (k - 1)) {
                deque.poll();
            }
            if(i < nums.length - 1) {
                while(deque.peekLast() != null && nums[deque.peekLast()] <= nums[i + 1]) {
                    deque.pollLast();
                }
                deque.offer(i + 1);
            }
        }
        return maxArray;
    }
}
