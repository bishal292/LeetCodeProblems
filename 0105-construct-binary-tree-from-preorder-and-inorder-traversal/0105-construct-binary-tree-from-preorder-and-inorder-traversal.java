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
    HashMap<Integer, Integer> in = new HashMap<>();
    int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // BruteForce Solution.

        // if (preorder.length < 1)
        //     return null;
        // TreeNode root = new TreeNode(preorder[0]); // root Node.
        // int idx = -1;
        // for (int i = 0; i < inorder.length; i++) {
        //     if (inorder[i] == preorder[0]) {
        //         idx = i;
        //         break;
        //     }
        // }
        // root.left = buildTree(Arrays.copyOfRange(preorder, 1, idx + 1), Arrays.copyOfRange(inorder, 0, idx));
        // root.right = buildTree(Arrays.copyOfRange(preorder,idx + 1,preorder.length), Arrays.copyOfRange(inorder, idx+1, inorder.length));
        // return root;

        // Optimized Solution.
        for (int i = 0; i < inorder.length; i++) {
            in.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length-1);
    }

    public TreeNode build(int [] preorder ,int start,int end){
        if(start > end)return null;
        TreeNode root = new TreeNode(preorder[preIdx++]);
        int idx = in.get(root.val);

        root.left = build(preorder,start,idx-1);
        root.right = build(preorder,idx+1,end);
        return root;
    }
}