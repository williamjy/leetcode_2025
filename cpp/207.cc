class Solution {
    public:
        bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
            vector<vector<bool>> graph(numCourses, vector<bool> (numCourses, false));
            vector<bool> visited(numCourses, false);
            vector<bool> path(numCourses, false);
            for (auto prerequisite : prerequisites) {
                graph[prerequisite[0]][prerequisite[1]] = true;
            }
            bool result = true;
            for (int i = 0; i < numCourses; i++) {
                path[i] = true;
                result &= search(numCourses, graph, visited, path, i);
                path[i] = false;
            }
            return result;
        }
    
        bool search(int numCourses, vector<vector<bool>>& graph, vector<bool>& visited, vector<bool>& path, int node) {
            bool result = true;
            if (!visited[node]) {
                visited[node] = true;
                for (int i = 0; i < numCourses; i++) {
                    if (graph[node][i] == true) {
                        if (path[i] == true) {
                            return false;
                        } else {
                            path[i] = true;
                            result &= search(numCourses, graph, visited, path, i);
                            path[i] = false;
                        }
                    }
                }
            }
            return result;
        }
    };