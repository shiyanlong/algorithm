import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class Day05 {

    private class Solute {

        private int _sum = Integer.MAX_VALUE;

        // 递归解法：超时
        private void find(int[][] grid, int x, int y, int tempSum) {
            int xLen = grid.length;
            int yLen = grid[0].length;
            // 判断基本 x、y 不越界，临时 tempSum 小于 sum 才继续
            if (x >= xLen || y >= yLen)
                return;

            tempSum += grid[x][y];

            if (tempSum > _sum)
                return;

            if (x == xLen - 1 && y == yLen - 1) {
                _sum = tempSum < _sum? tempSum: _sum;
            }

            find(grid, x + 1, y, tempSum);
            find(grid, x, y + 1, tempSum);
        }

        private int minPathSum(int[][] grid) {
            find(grid, 0, 0, 0);
            return _sum;
        }

        private int q1(int[][] grid) {
            int xLen = grid.length;
            int yLen = grid[0].length;
            int dp[][] = new int[xLen][yLen];
            dp[0][0] = grid[0][0];

            // 填写第一行
            for (int i = 1; i < yLen; i ++) {
                dp[0][i] += dp[0][i - 1] + grid[0][i];
            }

            // 填写第二行
            for (int i = 1; i < xLen; i ++) {
                dp[i][0] += dp[i - 1][0] + grid[i][0];
            }

            for (int i = 1; i < xLen; i ++) {
                for (int j = 1; j < yLen; j ++) {
                    int min = dp[i - 1][j] < dp[i][j - 1]? dp[i - 1][j]: dp[i][j - 1];
                    dp[i][j] += grid[i][j] + min;
                }
            }

            for (int i = 0; i < xLen; i ++) {
                System.out.println(Arrays.toString(dp[i]));
            }

            return dp[xLen - 1][yLen - 1];
        }
    }

    private Solute solute = null;
    private int[][] arr = null;

    @Before
    public void before() {
//        arr = new int[][]{
//                {1,3,1},
//                {1,5,1},
//                {4,2,1}
//        };
        arr = new int[][]{
                {1,2},
                {5,6},
                {1,1}
        };
        solute = new Solute();
    }

    @Test
    public void q1() {
//        System.out.println(solute.minPathSum(arr));
        System.out.println(solute.q1(arr));
    }
}