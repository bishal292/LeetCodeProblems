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
    TreeNode ans;
    int maxD = -1;
    int d = -1;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        ans = new TreeNode();
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null)
            return;
        int left = maxDepth(node.left,0);
        int right = maxDepth(node.right,0);
        if(left == right){
            ans = node;
        }else if(left > right){
            dfs(node.left);
        }else dfs(node.right);
    }

    public int maxDepth(TreeNode node, int depth) {
        if (node == null) {
            return -1;
        }
        int left = maxDepth(node.left,depth+1);
        int right = maxDepth(node.right,depth+1);
        return Math.max(depth,Math.max(left,right));
    }
}