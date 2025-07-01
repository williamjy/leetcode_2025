class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<vector<int>> graph(n, vector<int>(n, 0));
        for (auto flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }
        vector<int> distance(n, INT_MAX);
        distance[src] = 0;
        queue<int> node_queue;
        node_queue.push(src);
        for (int i = 0; i <= k; i++) {
            vector<bool> visited(n, false);
            queue<int> next_node_queue;
            vector<int> next_distance = distance;
            while(!node_queue.empty()) {
                int curr_node = node_queue.front();
                node_queue.pop();
                for (int next_node = 0; next_node < n; next_node++) {
                    if (graph[curr_node][next_node] > 0) {
                        if (distance[curr_node] < distance[next_node] - graph[curr_node][next_node] && distance[curr_node] < next_distance[next_node] - graph[curr_node][next_node]) {
                            next_distance[next_node] = distance[curr_node] + graph[curr_node][next_node];
                        }
                        if (!visited[next_node]) {
                            visited[next_node] = true;
                            next_node_queue.push(next_node);
                        }
                    }

                }
            }
            node_queue = next_node_queue;
            distance = next_distance;
        }
        if (distance[dst] == INT_MAX) {
            return -1;
        } else {
            return distance[dst];
        }
    }
};