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
    final int MOD = 1000000007;
    long totSum = 0l;
    long maxP = 0l;
    public int maxProduct(TreeNode root) {
        if(root == null)return 0;
        totSum = sum(root);
        maxP = 0l;
        dfs(root);
        return (int)(maxP % MOD);
    }
    public long sum(TreeNode node){
        if(node == null){
            return 0;
        }
        return node.val + sum(node.left)+sum(node.right);
    }
    public long dfs(TreeNode node){
        if(node == null)return 0;
        long left = dfs(node.left);
        long right = dfs(node.right);

        long subTrSum = node.val + left + right;
        long curPro = subTrSum * (totSum - subTrSum);
        maxP = Math.max(maxP,curPro);
        return subTrSum;
    }
}