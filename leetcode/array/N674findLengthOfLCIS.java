package leetcode.array;

/**
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * 注意：数组长度不会超过10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N674findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        int max = 0;
        int length = 1;

        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] < nums[i + 1]){
                length++;
            } else {
                if (length > max){
                    max = length;
                }
                length = 1;
            }
        }
        return max > length? max: length;
    }

    public static void main(String[] args) {
        N674findLengthOfLCIS s = new N674findLengthOfLCIS();

        System.out.println(s.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(s.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(s.findLengthOfLCIS(new int[]{1, 3, 5, 7}));
    }
}
