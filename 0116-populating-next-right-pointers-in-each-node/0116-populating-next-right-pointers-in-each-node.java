/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)return null;

        // Iterative and first Thought Approach.

        // Queue<Node> que = new LinkedList<>();
        // que.offer(root);
        // while(!que.isEmpty()){
        //     int n = que.size();
        //     for(int i = 0;i<n;i++){
        //         Node node = que.poll();
        //         if(node.left != null)que.offer(node.left);
        //         if(node.right != null)que.offer(node.right);
        //         if(i != n-1)node.next = que.peek();
        //     }
        // }
        // return root;

        // Recursive and a better Approach.

        // Node left = root.left;
        // Node right = root.right;
        // Node next = root.next;

        // if(left != null){ // if there exists a left child then it is guranted that there is a right child also as it is a perfect binary tree.
        //     left.next = right;
        //     if(next != null){
        //         right.next = next.left;
        //     }
        //     connect(left);
        //     connect(right);
        // }
        // return root;


        // Iterative and most Optimal 

        Node leftmost = root;
        while(leftmost.left != null){
            Node current = leftmost;
            while(current != null){
                current.left.next = current.right;
                if(current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}