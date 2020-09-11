package com.windranger;


import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        int[] nums = new int[]{70, 66, 120, 50, 25, 60, 110, 65, 18, 38, 100, 55};
        int[] nums = new int[]{7, 6, 8, 5, 4};
        Solution main = new Solution();
        int res = main.test(nums);
        System.out.println(res);
    }

    public int test(int[] nums) {
        int n = nums.length;
        // 0 递降，1 表示升，2 v，3w
        int[][][] dp = new int[n][n][4];
        // 1. 找 递增和递减
        for (int i = 0; i < n; i++) {
            // 其实i,i无意义，不是升/降，只是一个点
            dp[i][i][0] = 1;
            dp[i][i][1] = 1;
            for (int j = i + 1; j < n; j++) {
                // 代表不存在i,j的降
                dp[i][j][0] = 0;
                dp[i][j][1] = 0;
                int jj = nums[j];
                for (int k = i; k < j; k++) {
                    int kk = nums[k];
                    if (kk > jj && dp[i][k][0] + 1 > dp[i][j][0]) {
                        // 严格递减>
                        dp[i][j][0] = dp[i][k][0] + 1;
                    }
                    if (kk < jj && dp[i][k][1] + 1 > dp[i][j][1]) {
                        // 严格递增
                        dp[i][j][1] = dp[i][k][1] + 1;
                    }
                }
            }
        }
        // 2. 找v
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n; j++) {
                // 这里j=i+2，跟上面不同
                dp[i][j][2] = 0;
                for (int k = i + 1; k < j; k++) {
                    // 一定要存在降，若=0说明不存在降，那么不可能构成降升
                    if (dp[i][k][0] > 0 && dp[k][j][1] > 0 && dp[i][k][0] + dp[k][j][1] - 1 > dp[i][j][2]) {
                        dp[i][j][2] = dp[i][k][0] + dp[k][j][1] - 1;
                    }
                }
            }
        }
        // 3. 找w
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j][3] = 0;
                for (int k = i + 1; k < j; k++) {
                    if (dp[i][k][2] > 0 && dp[k][j][2] > 0 && dp[i][k][2] + dp[k][j][2] - 1 > dp[i][j][3]) {
                        dp[i][j][3] = dp[i][k][2] + dp[k][j][2] - 1;
                    }
                }
                res = Math.max(res, dp[i][j][3]);
            }
        }
        return res;
    }
}

