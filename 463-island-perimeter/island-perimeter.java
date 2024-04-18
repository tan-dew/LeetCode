class Solution {
    public int islandPerimeter(int[][] grid) {
        
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[row].length; col++){
                if (grid[row][col] == 1){
                    return dfs(grid, row, col, new boolean[grid.length][grid[row].length]);
                }
            }
        }
        
        return 0;
    }
    
    int dfs(int[][] grid, int row, int col, boolean[][] visited){
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[row].length - 1 || grid[row][col] == 0){
            return 1;
        }
        
        if (visited[row][col]){
            return 0;
        }
        
        visited[row][col] = true;
        
        int perimeter = dfs(grid, row - 1, col, visited) 
            + dfs(grid, row, col + 1, visited) 
            + dfs(grid, row + 1, col, visited)
            + dfs(grid, row, col - 1, visited);
        
        return perimeter;
    }
}