package leetcode;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */

class N198rob {
    public int rob(int[] nums) {

        int[] partMax = new int[nums.length];
        int max = 0;

        for (int i = 0; i< nums.length; i++){
//            System.out.println("i="+i);
            if (i == 0) {
                partMax[i] = nums[0];
                max = nums[0];
            }
            else if (i == 1) {
                partMax[i] = nums[1] > nums[0] ? nums[1] : nums[0];
                max = partMax[i];
            } else{
            max = Math.max(max, nums[i] + partMax[i - 2]);
            partMax[i] = max;
            }
        }
        return partMax[nums.length - 1];
    }

    public static void main(String[] args){
        int[] num = {1, 2, 3, 1};
        int[] num1 = {2, 7, 9, 3, 1};
        N198rob s = new N198rob();
        System.out.println(s.rob(num));     // 4
        System.out.println(s.rob(num1));    // 12
    }
}
