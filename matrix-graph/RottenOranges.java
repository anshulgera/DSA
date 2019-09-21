import java.util.*;

public class RottenOranges {

    private static class Node {
        private int x, y, depth;
        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    private static void addNeighbours(Node curr, Queue<Node> q, int[][] grid) {
        int x = curr.x;
        int y = curr.y;
        int currDepth = curr.depth;
        if ((x-1)>0 && grid[x-1][y] == 1) {
            Node temp = new Node(x-1, y, currDepth+1);
            q.add(temp);
            grid[x-1][y] = 2;
        }
        if ((y-1)>0 && grid[x][y-1] == 1) {
            Node temp = new Node(x, y-1, currDepth+1);
            grid[x][y-1] = 2;
            q.add(temp);
        }
        if ((x+1)<grid.length && grid[x+1][y] == 1) {
            Node temp = new Node(x+1, y, currDepth+1);
            grid[x+1][y] = 2;
            q.add(temp);
        }
        if ((y+1)<grid[0].length && grid[x][y+1] == 1) {
            Node temp = new Node(x, y+1, currDepth+1);
            grid[x][y+1] = 2;
            q.add(temp);
        }

    }

    private static void solve(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        int depth = 0;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == 2) {
                    Node rottenOrange = new Node(i,j,depth);
                    q.add(rottenOrange);
                }
            }
        }   

        int maxDepthSoFar = 0;
        while (q.size() > 0) {
            Node curr = q.peek();
            maxDepthSoFar = curr.depth;
            q.remove();
            addNeighbours(curr, q, grid);
        }

        // Check if any fresh orange is left in the grid or not
         

    }
    public static void main(String[] args) {
        // int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        int[][] grid = {{0,2}};
        solve(grid);
        

    }
}