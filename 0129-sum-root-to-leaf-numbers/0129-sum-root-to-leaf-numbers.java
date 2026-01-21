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
        // if (root == null)
        //     return 0;
        return helper(root, 0);
    }

    public int helper(TreeNode node, int preSum) {
        // preSum = preSum * 10 + node.val;
        // if (node.left == null && node.right == null)
        //     return preSum;
        // int l = 0, r = 0;
        // if (node.left != null)
        //     l = helper(node.left, preSum);
        // if (node.right != null)
        //     r = helper(node.right, preSum);

        // return l + r;
        
        if(node == null)return 0;

        preSum = preSum * 10 + node.val;
        if(node.left == null && node.right == null)return preSum;
        
        return helper(node.left,preSum) + helper(node.right,preSum);
    }
}