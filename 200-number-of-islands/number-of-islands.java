class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islandCount = 0;
        
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[row].length; col++){
                if (!visited[row][col] && grid[row][col] == '1'){
                    islandCount++;
                    explore(grid, row, col, visited);
                }
            }
        }
        
        return islandCount;
    }
    
    public void explore(char[][] grid, int row, int col, boolean[][] visited){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == '0' || visited[row][col]){
            return;
        }
        
        visited[row][col] = true;
        
        explore(grid, row + 1, col, visited);
        explore(grid, row - 1, col, visited);
        explore(grid, row, col + 1, visited);
        explore(grid, row, col - 1, visited);
    }
}