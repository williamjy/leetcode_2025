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
    public boolean isValidBST(TreeNode root) {
        return checkRecursively(root, false, Integer.MAX_VALUE, false, Integer.MIN_VALUE);
    }

    public boolean checkRecursively(TreeNode root, boolean mustLess, int lessNumber, boolean mustGreater, int greaterNumber) {
        if (root == null) {
            return true;
        }
        if (mustLess && root.val >= lessNumber) {
            return false;
        }
        if (mustGreater && root.val <= greaterNumber) {
            return false;
        }
        boolean result = true;
        result &= checkRecursively(root.left, true, Math.min(lessNumber, root.val), mustGreater, greaterNumber);
        result &= checkRecursively(root.right, mustLess, lessNumber, true, Math.max(greaterNumber, root.val));
        return result;
    }
}