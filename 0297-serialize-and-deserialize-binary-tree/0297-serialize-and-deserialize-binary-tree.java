/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int idx = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        preorder(root, list);
        return list.toString();
    }

    public void preorder(TreeNode node, ArrayList<String> list) {
        if (node == null) {
            list.add("null");
            return;
        }
        list.add(node.val + "");
        preorder(node.left, list);
        preorder(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Remove [ ]
        data = data.substring(1, data.length() - 1);

        // Split by comma
        String[] nodes = data.split(", ");

        idx = 0;
        return build(nodes);
    }

    private TreeNode build(String[] nodes) {
        if (idx >= nodes.length)
            return null;

        String val = nodes[idx++];

        if (val.equals("null"))
            return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = build(nodes);
        node.right = build(nodes);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));