class Solution:
    
    def is_valid(self, grid, n, m, x, y):
        if (x>=0 and x<n) and (y>=0 and y<m):
            return True
        return False
    
    def explore(self, grid, n, m, x, y):
        # mark visited
        grid[x][y] = 0
        # up
        if self.is_valid(grid, n, m, x-1, y) and grid[x-1][y] == "1":
            self.explore(grid, n, m, x-1, y)
        # right
        if self.is_valid(grid, n, m, x, y+1) and grid[x][y+1] == "1":
            self.explore(grid, n, m, x, y+1)
        # down
        if self.is_valid(grid, n, m, x+1, y) and grid[x+1][y] == "1":
            self.explore(grid, n, m, x+1, y)
        # left
        if self.is_valid(grid, n, m, x, y-1) and grid[x][y-1] == "1":
            self.explore(grid, n, m, x, y-1)
        
        
    def numIslands(self, grid) -> int:
        if not grid:
            return 0
        n = len(grid)
        m = len(grid[0])
        count = 0
        # check for 1s
        for i in range(n):
            for j in range(m):
                if grid[i][j] == "1":
                    # print(f'i {i} j {j}')
                    count += 1
                    self.explore(grid, n, m, i, j)
        return count
        
a = Solution()
