import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class Day02 {

    private class Solute {

        private int[] q1(int[] arr1, int[] arr2) {
            int len1 = arr1.length;
            int len2 = arr2.length;
            int lenResult = len1 + len2;
            int[] result = new int[lenResult];
            int index = lenResult - 1;

            for (int i = len1 - 1; i >= 0; i --) {
                for (int j = len2 - 1, r = index; j >= 0; j --, r --) {
                    result[r] += arr1[i] * arr2[j];
                }

                index --;
            }

            for (int j = lenResult - 1; j > 0; j --) {
                if (result[j] > 9) {
                    int temp = result[j];
                    result[j] = temp % 10;
                    result[j - 1] += temp / 10;
                }
            }

            if (result[0] == 0) {
                int[] arr = new int[lenResult - 1];
                System.arraycopy(result, 1, arr, 0, lenResult - 1);
                return arr;
            }
            return result;
        }
    }

    private Solute solute;
    private int[] arr1;
    private int[] arr2;

    @Before
    public void before() {
        solute = new Solute();
        arr1 = new int[]{9,8};
        arr2 = new int[]{9,9};
    }

    @Test
    public void q1() {
        System.out.println(Arrays.toString(solute.q1(arr1, arr2)));
    }
}
