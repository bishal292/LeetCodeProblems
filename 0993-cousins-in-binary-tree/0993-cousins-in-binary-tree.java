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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean oneFound = false;
        while(!queue.isEmpty()){
            int k = queue.size();
            for(int i = 0;i<k;i++){
                TreeNode cur = queue.poll();
                if(cur.val == x || cur.val == y){
                    if(oneFound)return true;
                    oneFound = true;
                }
                if(cur.left != null && cur.right !=null && (cur.left.val == x || cur.left.val == y) && (cur.right.val == x || cur.right.val == y))return false; // Direct Siblings.
                if(cur.left != null)queue.offer(cur.left);
                if(cur.right != null)queue.offer(cur.right);
            }
            if(oneFound)return false;
        }
        return false;
    }
}