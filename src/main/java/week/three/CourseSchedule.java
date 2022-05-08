package week.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author XiongShiyu
 * @description CourseSchedule
 * @date 2022/5/9 0:18
 */
public class CourseSchedule {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap();
        int[] array = new int[numCourses];
        for(int[] course : prerequisites) {
            HashSet<Integer> set = map.getOrDefault(course[1], new HashSet<Integer>());
            set.add(course[0]);
            map.put(course[1], set);
            array[course[0]]++;
        }
        List<Integer> original = new ArrayList();
        for(int i = 0; i < numCourses; i++) {
            original.add(i);
        }
        int index = 0;
        int[] ret = new int[numCourses];
        boolean isChange = false;
        while(!original.isEmpty()) {
            Integer need = original.get(index);
            if(array[need] == 0) {
                HashSet<Integer> set = map.getOrDefault(need, new HashSet<Integer>());
                for(Integer val : set) {
                    array[val]--;
                }
                ret[numCourses - original.size()] = need;
                original.remove(index);
                isChange = true;
                if(index > original.size() - 1) {
                    index = 0;
                }
            }else{
                if(index == original.size() - 1 && !isChange) {
                    return new int[0];
                }
                if(index < original.size() - 1) {
                    index++;
                }else{
                    isChange = false;
                    index = 0;
                }
            }
        }
        return ret;
    }
}
