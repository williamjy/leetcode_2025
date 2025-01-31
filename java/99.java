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
    public void recoverTree(TreeNode root) {
        List<TreeNode> convertedList = new ArrayList<TreeNode>();
        convertToInorder(root, convertedList);
        TreeNode firstSwap = null;
        TreeNode secondSwap = null;
        boolean isFirstSwap = true;
        for (int i = 0; i < convertedList.size() - 1; i++) {
            TreeNode curr = convertedList.get(i);
            TreeNode next = convertedList.get(i + 1);
            if (curr.val >= next.val) {
                if (isFirstSwap) {
                    firstSwap = curr;
                    secondSwap = next;
                    isFirstSwap = false;
                } else {
                    secondSwap = next;
                    break;
                }
            }
        }
        int tmp = firstSwap.val;
        firstSwap.val = secondSwap.val;
        secondSwap.val = tmp;
    }

    public void convertToInorder(TreeNode root, List<TreeNode> convertedList) {
        if (root == null) {
            return;
        }
        convertToInorder(root.left, convertedList);
        convertedList.add(root);
        convertToInorder(root.right, convertedList);
        return;
    }
}