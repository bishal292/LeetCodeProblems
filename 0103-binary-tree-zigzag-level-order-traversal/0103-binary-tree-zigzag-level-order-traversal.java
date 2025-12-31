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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Deque<TreeNode> que = new ArrayDeque<>();
        boolean rev = false;
        que.offer(root);
        while (!que.isEmpty()) {
            List<Integer> inner = new ArrayList<>();
            int n = que.size();
            for (int i = 0; i < n; i++) {
                if (!rev) {
                    TreeNode node = que.pollFirst();
                    if (node.left != null)
                        que.offerLast(node.left);
                    if (node.right != null)
                        que.offerLast(node.right);
                    inner.add(node.val);
                } else {
                    TreeNode node = que.pollLast();
                    if (node.right != null)
                        que.offerFirst(node.right);
                    if (node.left != null)
                        que.offerFirst(node.left);
                    inner.add(node.val);
                }
            }
            ans.add(inner);
            rev = !rev;
        }
        return ans;
    }
}