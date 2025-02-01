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
        if (root == null) {
            return root;
        }
        Queue<Node> currQueue = new LinkedList<Node>();
        Queue<Node> nextQueue = new LinkedList<Node>();
        currQueue.add(root);
        while (true) {
            Node prev = null;
            Node curr = null;
            while (!currQueue.isEmpty()) {
                prev = curr;
                curr = currQueue.poll();
                if (prev != null) {
                    prev.next = curr;
                }
                curr.next = null;
                if (curr.left != null) {
                    nextQueue.add(curr.left);
                }
                if (curr.right != null) {
                    nextQueue.add(curr.right);
                }
            }
            currQueue = nextQueue;
            nextQueue = new LinkedList<Node>();
            if (currQueue.isEmpty()) {
                break;
            }
        }
        return root;
    }
}