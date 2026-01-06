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
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> deq = new LinkedList<>();
        deq.offer(root);
        int level = 0;
        int idx = 0;
        while(!deq.isEmpty()){
            int s = deq.size();
            int sum = 0;
            level++;
            for(int i = 0;i<s;i++){
                TreeNode node = deq.poll();
                sum += node.val;
                if(node.left != null)deq.offer(node.left);
                if(node.right != null)deq.offer(node.right);
            }
            if(sum > maxSum){
                    maxSum = sum;
                    idx = level;
            }
        }
        return idx;
    }
}