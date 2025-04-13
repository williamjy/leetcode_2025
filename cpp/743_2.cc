class Solution {
    public:
        int networkDelayTime(vector<vector<int>>& times, int n, int k) {
            vector<int> distance(n + 1, 20000);
            distance[k] = 0;
            vector<vector<int>> adjacent_list(n + 1, vector<int>(n + 1, -1));
            for (auto time : times) {
                adjacent_list[time[0]][time[1]] = time[2];
            }
            search(times, n, k, adjacent_list, distance);
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
        void search(vector<vector<int>>& times, int n, int from, vector<vector<int>>& adjacent_list, vector<int>& distance) {
            for (int to = 1; to <= n; to++) {
                if (adjacent_list[from][to] != -1) {
                    if (distance[from] + adjacent_list[from][to] < distance[to]) {
                        distance[to] = distance[from] + adjacent_list[from][to];
                        search(times, n, to, adjacent_list, distance);
                    }
                }
            }
        }
    };