package study.toFlashBack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day13 {

    @SuppressWarnings("unchecked")
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] arr = new int[k];
        arr[0] = 1;
        int i = 0;

        while (arr[0] <= n - k + 1) {
            if (i < k - 1 && arr[i] <= n) {
                arr[i + 1] = arr[i] + 1;
                i ++;
            } else {
                if (i == k - 1 && arr[i] <= n) {
                    while (arr[i] <= n) {
                        List<Integer> temp = new ArrayList<>();
                        for (int data: arr) {
                            temp.add(data);
                        }
                        result.add(temp);
                        arr[i] ++;
                    }
                }
                if (i != 0) i --;
                arr[i] ++;
            }
        }
        return result;
    }

    @Test
    public void a() {
        List<List<Integer>> combine = combine(1, 1);
        for (List<Integer> list: combine) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
