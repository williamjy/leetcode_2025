class Solution {
    public:
        int maxAreaOfIsland(vector<vector<int>>& grid) {
            vector<vector<bool>> visited(grid.size(), vector<bool>(grid[0].size(), false));
            int maxSize = 0;
            for (int i = 0; i < grid.size(); i++) {
                for (int j = 0; j < grid[0].size(); j++) {
                    int size = search(grid, visited, i, j);
                    if (size > maxSize) {
                        maxSize = size;
                    }
                }
            }
            return maxSize;
        }
        int search(vector<vector<int>>& grid, vector<vector<bool>>& visited, int i, int j) {
            if (i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size()) {
                return 0;
            }
            if (grid[i][j] == 0 || visited[i][j]) {
                return 0;
            }
            int size = 1;
            visited[i][j] = true;
            size += search(grid, visited, i - 1, j);
            size += search(grid, visited, i + 1, j);
            size += search(grid, visited, i, j - 1);
            size += search(grid, visited, i, j + 1);
            return size;
        }
    };