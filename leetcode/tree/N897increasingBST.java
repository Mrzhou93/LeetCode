package leetcode.tree;

import leetcode.TreeNode;

/**
 * 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 *  
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *  
 *
 * 提示：
 *
 * 给定树中的结点数介于 1 和 100 之间。
 * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N897increasingBST {
    public leetcode.TreeNode increasingBST(leetcode.TreeNode root) {
        return increasingBST(root, null);
    }

    public leetcode.TreeNode increasingBST(leetcode.TreeNode root, leetcode.TreeNode next){
        if (root == null)
            return null;

        if (root.right == null){
            root.right = next;
        } else {
            root.right = increasingBST(root.right, next);
        }

        if (root.left == null){
            return root;
        }

        next = root;
        TreeNode ans = increasingBST(root.left, next);
        root.left = null;

        return ans;
    }
}
