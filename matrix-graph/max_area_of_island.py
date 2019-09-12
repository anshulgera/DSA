class Solution:
    def explore(self, grid, n, m, i ,j, result):
        grid[i][j] = 0
        result[0] += 1
        if result[0] > result[1]:
            result[1] = result[0]

        # up
        if (i-1)>=0 and grid[i-1][j] == 1:
            self.explore(grid, n, m, i-1 ,j, result)
        # right
        if (j+1)<=(m-1) and grid[i][j+1] == 1:
            self.explore(grid, n, m, i, j+1, result)
        
        # down
        if (i+1)<=(n-1) and grid[i+1][j] == 1:
            self.explore(grid, n, m, i+1 ,j, result)
        
        # left
        if j-1>=0 and grid[i][j-1] == 1:
            self.explore(grid, n, m, i, j-1, result)

        
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        n = len(grid)
        m = len(grid[0])
        
        # size_so_far and max_size
        result = [0, 0]
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    result[0] = 0
                    self.explore(grid, n, m, i, j, result)
        return result[1]