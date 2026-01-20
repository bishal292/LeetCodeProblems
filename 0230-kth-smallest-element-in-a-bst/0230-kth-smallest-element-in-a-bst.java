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
    int curIdx = 0;
    public int kthSmallest(TreeNode root, int k) {
        curIdx = 0;
        ArrayList<TreeNode> list = new ArrayList<>();
        // inorder Traversal;
        inorder(root,list);
        return list.get(k-1).val;
    }
    public void inorder(TreeNode node,ArrayList<TreeNode> list){
        if(node == null)return;
        inorder(node.left,list);
        list.add(node);
        inorder(node.right,list);
    }
    public TreeNode inorder(TreeNode node,int k){
        if(node == null)return null;
        TreeNode left = inorder(node.left,k);
        if(left != null)return left;
        curIdx++;
        if(curIdx == k)return node;
        return inorder(node.right,k);
    }
}