package leetcode;

import java.util.Arrays;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */

public class N96numTrees {
    public int numTrees(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
//        dp[2] = 2;

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

//        System.out.println(Arrays.toString(dp));

        return dp[n];
    }

    public static void main(String[] args){
        N96numTrees s = new N96numTrees();

        System.out.println(s.numTrees(6));
    }
}