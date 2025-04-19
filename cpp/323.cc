class Solution {
    public:
        int countComponents(int n, vector<vector<int>>& edges) {
            vector<bool> visited(n, false);
            vector<vector<bool>> adjacent_list(n, vector<bool>(n, false));
            for (auto edge : edges) {
                adjacent_list[edge[0]][edge[1]] = true;
                adjacent_list[edge[1]][edge[0]] = true;
            }
            int component = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    queue<int> q;
                    q.push(i);
                    while (!q.empty()) {
                        int j = q.front();
                        q.pop();
                        if (!visited[j]) {
                            visited[j] = true;
                            for (int k = 0; k < n; k++) {
                                if (adjacent_list[j][k] && !visited[k]) {
                                    q.push(k);
                                }
                            }
                        }
                    }
                    component++;
                }
            }
            return component;
        }
    };