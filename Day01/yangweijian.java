import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class Day01 {

    private class Solute {
        private int[] q1(int[] arr, int n) {
            if (n >= arr.length) {
                System.out.println("数组越界");
                return new int[0];
            }
            int len = arr.length;
            System.arraycopy(arr, n + 1, arr, n, len - n - 1);
            arr[len - 1] = 0;
            return arr;
        }

        private int[] q2(int[] arr) {
            int[] result = null;
            int len = arr.length;
            boolean flag = true;

            for (int data: arr) {
                if (data != 9) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result = new int[arr.length + 1];
                result[0] = 1;
                return result;
            }
            arr[len - 1] += 1;
            for (int i = len - 1; i > 0; i --) {
                if (arr[i] > 9) {
                    arr[i - 1] += 1;
                    arr[i] -= 10;
                } else {
                    break;
                }
            }
            return arr;
        }

        private int[] q3(int[] arr1, int[] arr2) {
            int[] big = arr1.length >= arr2.length? arr1: arr2;
            int[] small = arr1.length < arr2.length? arr1: arr2;

            for (int i = small.length - 1, j = 1; i >= 0; i --, j ++) {
                big[big.length - j] += small[i];
            }

            for (int i = big.length - 1; i > 0; i --) {
                if (big[i] > 9) {
                    big[i - 1] += 1;
                    big[i] -= 10;
                }
            }

            if (big[0] > 9) {
                int[] reslut = new int[big.length + 1];
                System.arraycopy(big, 0, reslut, 1, big.length);
                reslut[0] += 1;
                reslut[1] -= 10;
                return reslut;
            }
            return big;
        }
    }

    private int[] arr = null;
    private int[] getArr = null;
    private Solute solute = null;

    @Before
    public void before() {
        solute = new Solute();
        arr = new int[]{9,9,9};
        getArr = new int[]{9,9};
    }

    @Test
    public void q1() {
        System.out.println(Arrays.toString(solute.q1(arr, 3)));
    }

    @Test
    public void q2() {
        System.out.println(Arrays.toString(solute.q2(arr)));
    }

    @Test
    public void q3() {
        System.out.println(Arrays.toString(solute.q3(arr, getArr)));
    }
}
