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
    public void flatten(TreeNode root) {
        if(root == null)return;
        List<TreeNode> list = new LinkedList<>();
        pot(list,root);
        for(int i = list.size() - 2;i >= 0;i--){
            TreeNode cur = list.get(i);
            cur.left = null;
            cur.right = list.get(i + 1);
        }
    }
    public void pot(List<TreeNode> list,TreeNode node){
        if(node == null)return;
        list.add(node);
        pot(list,node.left);
        pot(list,node.right);
    }
}