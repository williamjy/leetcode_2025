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
    int maxLength = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        search(root);
        return maxLength;
    }

    public int search(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftLength = search(root.left) + 1;
        int rightLength = search(root.right) + 1;
        maxLength = Math.max(maxLength, leftLength + rightLength);
        return Math.max(leftLength, rightLength);
    }
}