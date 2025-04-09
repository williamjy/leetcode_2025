/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
    public:
        Node* cloneGraph(Node* node) {
            vector<Node*> visited(101, nullptr);
            return cloneRecursively(node, visited);
        }
        Node* cloneRecursively(Node* node, vector<Node*>& visited) {
            if (node == nullptr) {
                return NULL;
            }
            if (visited[node->val] != nullptr) {
                return visited[node->val];
            }
            Node* curr_node = new Node(node->val);
            visited[node->val] = curr_node;
            for (auto neighbor : node->neighbors) {
                Node* cloned_neighbor = cloneRecursively(neighbor, visited);
                if (cloned_neighbor != nullptr) {
                    curr_node->neighbors.push_back(cloned_neighbor);
                }
            }
            return curr_node;
        }
    };