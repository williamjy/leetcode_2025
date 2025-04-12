class Solution {
    public:
        int networkDelayTime(vector<vector<int>>& times, int n, int k) {
            vector<int> prev(n + 1, 0);
            vector<int> distance(n + 1, 20000);
            vector<int> visited(n + 1, false);
            vector<vector<int>> adjacent_list(n + 1, vector<int>(n + 1, -1));
            for (auto time : times) {
                adjacent_list[time[0]][time[1]] = time[2];
            }
    
            distance[k] = 0;
    
            for (int i = 1; i <= n; i++) {
                int min_node = 0;
                for (int j = 1; j <= n; j++) {
                    if (!visited[j] && distance[j] < distance[min_node]) {
                        min_node = j;
                    }
                }
                visited[min_node] = true;
                for (int j = 1; j <= n; j++) {
                    if (!visited[j] && adjacent_list[min_node][j] != -1) {
                        if (distance[min_node] + adjacent_list[min_node][j] < distance[j]) {
                            prev[j] = min_node;
                            distance[j] = distance[min_node] + adjacent_list[min_node][j];
                        }
                    }
                }
            }
    
            int max_time = 0;
            for (int i = 1; i <= n; i++) {
                if (distance[i] > max_time) {
                    max_time = distance[i];
                }
            }
            if (max_time == 20000) {
                return -1;
            }
            return max_time;
        }
    };