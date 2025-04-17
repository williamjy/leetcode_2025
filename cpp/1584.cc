
class Solution {
    public:
        int minCostConnectPoints(vector<vector<int>>& points) {
            if (points.size() == 1) {
                return 0;
            }
            map<int, set<vector<int>>, std::less<int>> edges;
            for (int i = 0; i < points.size() - 1; i++) {
                for (int j = i + 1; j < points.size(); j++) {
                    int length = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]);
                    vector<int> node_pair = {i, j};
                    edges[length].insert(node_pair);
                }
            }
            vector<bool> visited(points.size(), false);
            int distance = 0;
            visited[(*edges.begin()->second.begin())[0]] = true;
            for (int i = 1; i < points.size(); i++) {
                for (auto edge_iter = edges.begin(); edge_iter != edges.end(); ) {
                    int length = edge_iter->first;
                    auto nodes = edge_iter->second;
                    bool found = false;
                    for (auto node_iter = nodes.begin(); node_iter != nodes.end();) {
                        if (visited[(*node_iter)[0]] && visited[(*node_iter)[1]]) {
                            node_iter = nodes.erase(node_iter);
                        } else if (!visited[(*node_iter)[0]] && !visited[(*node_iter)[1]]) {
                            ++node_iter;
                        } else {
                            visited[(*node_iter)[0]] = true;
                            visited[(*node_iter)[1]] = true;
                            distance += length;
                            node_iter = nodes.erase(node_iter);
                            found = true;
                            break;
                        }
                    }
                    if (nodes.empty()) {
                        edge_iter = edges.erase(edge_iter);
                    } else {
                        ++edge_iter;
                    }
                    if (found) {
                        break;
                    }
                }
            }
            return distance;
        }
    };