def validCell(i, j, n, arr):
    if i>=0 and i<n and j>=0 and j<n and arr[i][j]==1:
        return True
    return False
    
def explorePaths(arr, i, j, n, currentPath, allPaths):
    if i==n-1 and j==n-1:
        allPaths.append(currentPath)
        return
    if validCell(i, j, n, arr):
        arr[i][j] = 0
        explorePaths(arr, i+1, j, n, currentPath+"D", allPaths)
        explorePaths(arr, i-1, j, n, currentPath+"U", allPaths)
        explorePaths(arr, i, j+1, n, currentPath+"R", allPaths)
        explorePaths(arr, i, j-1, n, currentPath+"L", allPaths)
        arr[i][j] = 1

def findPath(arr, n):
    # code here
    currentPath = ""
    allPaths = []
    explorePaths(arr, 0, 0, n, currentPath, allPaths)
    allPaths.sort()
    return " ".join(allPaths)