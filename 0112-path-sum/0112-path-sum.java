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
    // public boolean hasPathSum(TreeNode root, int targetSum) {
    //     if(root == null)return false;
    //     return helper(root,targetSum);
    // }
    // public boolean helper(TreeNode root, int targetSum) {
    //     if(root == null)return false;
    //     int v = root.val;
    //     if(root.left == null && root.right == null && targetSum - v == 0)return true;
    //     return helper(root.left,targetSum - root.val) || helper(root.right,targetSum - root.val);
    // }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)return false;
        int v = root.val;
        if(root.left == null && root.right == null && targetSum - v == 0)return true;
        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }
}