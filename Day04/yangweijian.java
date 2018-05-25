import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day04 {

    private class Solute {

        private List<List<Integer>> add(int i, int j, int k, List<List<Integer>> result) {
            Integer[] tempArr = new Integer[]{i, j, k};
            Arrays.sort(tempArr);
            List<Integer> tempList = Arrays.asList(tempArr);
            if (!result.contains(tempList)) {
                result.add(tempList);
            }
            return result;
        }

        private List<List<Integer>> q1(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            int len = nums.length;
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));
            for (int i = 0; i < len; i ++) {
                for (int j = i + 1; j < len; j ++) {
                    int start = j + 1;
                    int end = len - 1;
                    while (start <= end) {
                        int middle = (start + end) / 2;
                        int sum = nums[i] + nums[j] + nums[middle];
                        if (sum == 0) {
                            result = add(nums[i], nums[j], nums[middle], result);
                            break;
                        } else if (sum < 0) {
                            start = middle + 1;
                        } else {
                            end = middle - 1;
                        }
                    }
                }
            }
            return result;
        }
    }

    private Solute solute = null;
    private int[] arr = null;

    @Before
    public void before() {
        solute = new Solute();
        arr = new int[]{0,2,2,3,0,1,2,3,-1,-4,2};
//        arr = new int[]{-1, 0, 1, 2, -1, -4};
    }

    @Test
    public void q1() {
        List<List<Integer>> lists = solute.q1(arr);
        for (List list: lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
