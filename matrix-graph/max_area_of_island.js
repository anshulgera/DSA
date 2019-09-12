/**
 * @param {number[][]} grid
 * @return {number}
 */

const explore = (grid, n, m, i, j, result) => {
    if (i<0 || i>=n || j<0 || j>=m) {
        return;
    }
    if (grid[i][j] === 1) {
            grid[i][j] = 0;
            result.areaSoFar += 1;
            result.maxAreaSoFar = Math.max(result.areaSoFar, result.maxAreaSoFar);
            explore(grid, n, m, i-1, j, result);
            explore(grid, n, m, i, j+1, result);
            explore(grid, n, m, i+1, j, result);
            explore(grid, n, m, i, j-1, result);
        
    } else {
        return;
    }
}


var maxAreaOfIsland = function(grid) {
    let n = grid.length;
    let m = grid[0].length;
    
    let result = {
        maxAreaSoFar: 0,
        areaSoFar: 0
    }
    
    for (let i=0; i<n; i++) {
        for (let j=0; j<m; j++) {
            if (grid[i][j] === 1) {
                result.areaSoFar = 0;
                explore(grid, n, m, i, j, result);
            }
        }
    }
    return result.maxAreaSoFar;
    
};