package week.one;

/**
 * @author XiongShiyu
 * @description PlusOne
 * @date 2022/4/16 21:34
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] ints = new int[] {1, 2, 9, 9};
//        int[] ints = new int[] {9, 9, 9, 9};
        int[] retArray = plusOne(ints);
        for (int i : retArray) {
            System.out.print(i);
        }
    }

    public static int[] plusOne(int[] digits) {
        int num = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] == 9 && (i == digits.length - 1 || num == 1)) {
                digits[i] = 0;
                num = 1;
            } else if (num == 1) {
                digits[i] = digits[i] + 1;
                num = 0;
            } else {
                num = 0;
            }
        }
        if(num == 1) {
            int[] newRet = new int[digits.length + 1];
            newRet[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newRet[i + 1] = digits[i];
            }
            return newRet;
        }
        return digits;
    }
}
