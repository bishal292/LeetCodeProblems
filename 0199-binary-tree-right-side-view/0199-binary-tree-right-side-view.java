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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)return ans;
        Deque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);
        while(!que.isEmpty()){
            int n = que.size();
            ans.add(que.peekLast().val);
            for(int i = 0;i<n;i++){
                TreeNode node = que.pollLast();
                if(node.right != null)que.offerFirst(node.right);
                if(node.left != null)que.offerFirst(node.left);
            }
        }
        return ans;
    }
}