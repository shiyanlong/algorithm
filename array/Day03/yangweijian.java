import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class Day03 {

    private class Solute {

        private int[] reverseArray(int[] arr, int start, int end) {
            while (start < end) {
                arr[start] = arr[start] ^ arr[end];
                arr[end] = arr[start] ^ arr[end];
                arr[start] = arr[start] ^ arr[end];
                start ++;
                end --;
            }
            return arr;
        }

        private int[] q1(int[] arr, int k) {
            k = arr.length - k;
            arr = reverseArray(arr, 0, k - 1);
            arr = reverseArray(arr, k , arr.length - 1);
            arr = reverseArray(arr, 0, arr.length - 1);

            return arr;
        }

        private int[] q2(int[] arr) {
            int index = 0;
            for (int i = 0; i < arr.length; i ++) {
                if (arr[i] != 0) {
                    arr[index] = arr[i];
                    index ++;
                }
            }
            for (; index < arr.length; index ++) {
                arr[index] = 0;
            }
            return arr;
        }
    }

    private Solute solute;
    private int[] arr1;
    private int[] arr2;

    @Before
    public void before() {
        solute = new Solute();
        arr1 = new int[]{1,2,3,4,5};
        arr2 = new int[]{1,0,2,0,3,0,4};
    }

    @Test
    public void q1() {
        int k = 2;
        System.out.println(Arrays.toString(solute.q1(arr1, k)));
    }

    @Test
    public void q2() {
        System.out.println(Arrays.toString(solute.q2(arr2)));
    }
}
