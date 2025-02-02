/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return calculate(root, 0);
    }

    public int calculate(TreeNode root, int value) {
        int result = 0;
        if (root.left == null && root.right == null) {
            return value * 10 + root.val;
        }
        if (root.left != null) {
            result += calculate(root.left, value * 10 + root.val);
        }
        if (root.right != null) {
            result += calculate(root.right, value * 10 + root.val);
        }
        return result;
    }
}