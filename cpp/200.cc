class Solution {
    public:
        int numIslands(vector<vector<char>>& grid) {
            vector<vector<bool>> visited(grid.size(), vector<bool>(grid[0].size(), false));
            int result = 0;
            for (int i = 0; i < grid.size(); i++) {
                for (int j = 0; j < grid[0].size(); j++) {
                    result += search(grid, visited, i, j);
                }
            }
            return result;
        }
    
        int search(vector<vector<char>>& grid, vector<vector<bool>>& visited, int i, int j) {
            if (i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size()) {
                return 0;
            }
            if (visited[i][j]) {
                return 0;
            }
            visited[i][j] = true;
            if (grid[i][j] == '0') {
                return 0;
            }
            if (grid[i][j] == '1') {
                search(grid, visited, i - 1, j);
                search(grid, visited, i + 1, j);
                search(grid, visited, i, j - 1);
                search(grid, visited, i, j + 1);
            }
            return 1;
        }
    };